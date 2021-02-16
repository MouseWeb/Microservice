package br.com.mouseweb.loja.openfeign.impl;

import br.com.mouseweb.loja.dto.*;
import br.com.mouseweb.loja.entity.Compra;
import br.com.mouseweb.loja.enums.CompraState;
import br.com.mouseweb.loja.openfeign.CompraServiceFeingClient;
import br.com.mouseweb.loja.openfeign.FornecedorFeingClient;
import br.com.mouseweb.loja.openfeign.TransportadorClient;
import br.com.mouseweb.loja.repository.CompraRepository;
import br.com.mouseweb.loja.util.Endpoint;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CompraServiceFeingClientImpl implements CompraServiceFeingClient {

    private static final Logger LOG = LoggerFactory.getLogger(CompraServiceFeingClientImpl.class);

    @Autowired
    Endpoint endpoint;

    @Autowired
    private FornecedorFeingClient fornecedorClient;

    @Autowired
    private TransportadorClient transportadorClient;

    @Autowired
    private CompraRepository compraRepository;

    @HystrixCommand(threadPoolKey = "getByIdThreadPool")
    public Compra getById(Long id) {
        return compraRepository.findById(id).orElse(new Compra());
    }

    public Compra reprocessaCompra(Long id) {
        return null;
    }

    public Compra cancelaCompra(Long id) {
        return null;
    }

    @HystrixCommand(fallbackMethod = "realizaCompraFallback",
                                    threadPoolKey = "realizaCompraThreadPool")
    public Compra realizaCompra(CompraDTO compra) {

        Compra compraSalva = new Compra();
        compraSalva.setState(CompraState.RECEBIDO);
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());
        compraRepository.save(compraSalva);
        compra.setCompraId(compraSalva.getId());

        LOG.info("buscando informações do fornecedor de {}", compra.getEndereco().getEstado());
        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());
        LOG.info("relizado o pedido {}", pedido);

        compraSalva.setState(CompraState.PEDIDO_REALIZADO);
        compraSalva.setPedido(pedido.getId());
        compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
        compraRepository.save(compraSalva);

        InfoEntregaDTO entregaDto = new InfoEntregaDTO();
        entregaDto.setPedidoId(pedido.getId());
        entregaDto.setDataParaEntrega(LocalDate.now().plusDays(pedido.getTempoDePreparo()));
        entregaDto.setEnderecoOrigem(info.getEndereco());
        LOG.info("Informações da entrega {}", entregaDto);

        VoucherDTO voucher = transportadorClient.reservaEntrega(entregaDto);
        compraSalva.setState(CompraState.RESERVA_ENTREGA_REALIZADA);
        compraSalva.setDataParaEntrega(voucher.getPrevisaoParaEntrega());
        compraSalva.setVoucher(voucher.getNumero());
        LOG.info("Voucher salvo {}", voucher);

        compraRepository.save(compraSalva);
        LOG.info("Salvado pedido na base de dados {}", compraSalva);

        // teste para executar a requisiçao em 2 segundos para cair no Hiystrix Fallback
        /*try {
            Thread.sleep(200);
        } catch (InterruptedException e){
            e.printStackTrace();
        }*/

        return compraSalva;
    }

    public Compra realizaCompraFallback(CompraDTO compra) {
        if(compra.getCompraId() != null) {
            return compraRepository.findById(compra.getCompraId()).get();
        }

        Compra compraFallback = new Compra();
        compraFallback.setEnderecoDestino(compra.getEndereco().toString());
        return compraFallback;
    }

}
