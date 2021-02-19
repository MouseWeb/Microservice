package br.com.mouseweb.transportador.service.impl;

import br.com.mouseweb.transportador.controller.EntregaController;
import br.com.mouseweb.transportador.dto.EntregaDTO;
import br.com.mouseweb.transportador.dto.VoucherDTO;
import br.com.mouseweb.transportador.model.Entrega;
import br.com.mouseweb.transportador.repository.EntregaRepository;
import br.com.mouseweb.transportador.service.EntregaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EntregaServiceImpl implements EntregaService {

    private static final Logger LOG = LoggerFactory.getLogger(EntregaServiceImpl.class);

    @Autowired
    private EntregaRepository repository;

    public VoucherDTO reservaEntrega(EntregaDTO pedidoDTO) {

        Entrega entrega = new Entrega();
        entrega.setDataParaBusca(pedidoDTO.getDataParaEntrega());
        entrega.setPrevisaoParaEntrega(pedidoDTO.getDataParaEntrega().plusDays(1l));
        entrega.setEnderecoDestino(pedidoDTO.getEnderecoDestino());
        entrega.setEnderecoOrigem(pedidoDTO.getEnderecoOrigem());
        entrega.setPedidoId(pedidoDTO.getPedidoId());

        LOG.info("Salvando a entrega {}", entrega);
        repository.save(entrega);

        VoucherDTO voucher = new VoucherDTO();
        voucher.setNumero(entrega.getId());
        voucher.setPrevisaoParaEntrega(entrega.getPrevisaoParaEntrega());
        return voucher;
    }

}

