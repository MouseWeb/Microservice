package br.com.mouseweb.transportador.service;

import br.com.mouseweb.transportador.dto.EntregaDTO;
import br.com.mouseweb.transportador.dto.VoucherDTO;

public interface EntregaService {

	VoucherDTO reservaEntrega(EntregaDTO pedidoDTO);

}
