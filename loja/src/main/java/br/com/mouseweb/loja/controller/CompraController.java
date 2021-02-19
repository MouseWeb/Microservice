package br.com.mouseweb.loja.controller;

import br.com.mouseweb.loja.dto.CompraDTO;
import br.com.mouseweb.loja.entity.Compra;
import br.com.mouseweb.loja.openfeign.CompraServiceFeingClient;
import br.com.mouseweb.loja.openfeign.impl.CompraServiceFeingClientImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private static final Logger LOG = LoggerFactory.getLogger(CompraController.class);

    /*@Autowired
    private CompraService compraService;*/

    @Autowired
    private CompraServiceFeingClient compraServiceFeingClint;

    @GetMapping("/{id}")
    public Compra getById(@PathVariable("id") Long id) {
        return compraServiceFeingClint.getById(id);
    }

    @PostMapping
    public Compra realizaCompra(@RequestBody CompraDTO compra){
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //return compraService.realizaCompra(compra);
        LOG.info("Realizar a compra {}", compra);
        return compraServiceFeingClint.realizaCompra(compra);

    }
}
