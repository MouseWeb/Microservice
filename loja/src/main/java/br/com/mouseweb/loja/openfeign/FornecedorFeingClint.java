package br.com.mouseweb.loja.openfeign;

import br.com.mouseweb.loja.controller.dto.InfoFornecedorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("fornecedor")
public interface FornecedorFeingClint {

    @GetMapping("/info/{estado}")
    InfoFornecedorDTO getInfoPorEstado(@PathVariable String estado);

}
