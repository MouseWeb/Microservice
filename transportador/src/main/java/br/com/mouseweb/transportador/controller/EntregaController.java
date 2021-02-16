package br.com.mouseweb.transportador.controller;

import br.com.mouseweb.transportador.dto.EntregaDTO;
import br.com.mouseweb.transportador.dto.VoucherDTO;
import br.com.mouseweb.transportador.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entrega")
public class EntregaController {
	
	@Autowired
	private EntregaService entregaService;

	@PostMapping
	public VoucherDTO reservaEntrega(@RequestBody EntregaDTO pedidoDTO) {
		return entregaService.reservaEntrega(pedidoDTO);
	}

}
