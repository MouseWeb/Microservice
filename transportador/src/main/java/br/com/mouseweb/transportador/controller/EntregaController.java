package br.com.mouseweb.transportador.controller;

import br.com.mouseweb.transportador.dto.EntregaDTO;
import br.com.mouseweb.transportador.dto.VoucherDTO;
import br.com.mouseweb.transportador.service.EntregaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrega")
public class EntregaController {

	private static final Logger LOG = LoggerFactory.getLogger(EntregaController.class);
	
	@Autowired
	private EntregaService entregaService;

	@PostMapping
	public VoucherDTO reservaEntrega(@RequestBody EntregaDTO pedidoDTO) {
		LOG.info("Realizar a entrega {}", pedidoDTO);
		return entregaService.reservaEntrega(pedidoDTO);
	}

}
