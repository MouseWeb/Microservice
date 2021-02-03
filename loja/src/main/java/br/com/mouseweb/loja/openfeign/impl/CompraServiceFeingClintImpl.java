package br.com.mouseweb.loja.openfeign.impl;

import br.com.mouseweb.loja.controller.dto.CompraDTO;
import br.com.mouseweb.loja.controller.dto.InfoFornecedorDTO;
import br.com.mouseweb.loja.controller.dto.InfoPedidoDTO;
import br.com.mouseweb.loja.entity.Compra;
import br.com.mouseweb.loja.openfeign.CompraServiceFeingClint;
import br.com.mouseweb.loja.openfeign.FornecedorFeingClint;
import br.com.mouseweb.loja.util.Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceFeingClintImpl implements CompraServiceFeingClint {

    private final Logger log = LoggerFactory.getLogger(br.com.mouseweb.loja.service.impl.CompraServiceImpl.class);

    @Autowired
    Endpoint endpoint;

    @Autowired
    private FornecedorFeingClint fornecedorClient;

    public Compra realizaCompra(CompraDTO compra) {

        InfoFornecedorDTO info = fornecedorClient.getInfoPorEstado(compra.getEndereco().getEstado());

        InfoPedidoDTO pedido = fornecedorClient.realizaPedido(compra.getItens());

        log.info(info.getEndereco());

        Compra compraSalva = new Compra();
        compraSalva.setPedido(pedido.getId());
        compraSalva.setTempoDePreparo(pedido.getTempoDePreparo());
        compraSalva.setEnderecoDestino(compra.getEndereco().toString());

        return compraSalva;
    }


}
