package br.com.mouseweb.loja.openfeign;

import br.com.mouseweb.loja.dto.InfoEntregaDTO;
import br.com.mouseweb.loja.dto.VoucherDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("transportador")
public interface TransportadorClient {

    @RequestMapping(path="/entrega", method = RequestMethod.POST)
    public VoucherDTO reservaEntrega(InfoEntregaDTO pedidoDTO);

}
