package br.com.mouseweb.loja.controller;

import br.com.mouseweb.loja.dto.CompraDTO;
import br.com.mouseweb.loja.entity.Compra;
import br.com.mouseweb.loja.openfeign.CompraServiceFeingClint;
import br.com.mouseweb.loja.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compra")
public class CompraController {

    /*@Autowired
    private CompraService compraService;*/

    @Autowired
    private CompraServiceFeingClint compraServiceFeingClint;

    @GetMapping("/{id}")
    public Compra getById(@PathVariable("id") Long id) {
        return compraServiceFeingClint.getById(id);
    }

    @PostMapping
    public Compra realizaCompra(@RequestBody CompraDTO compra){
        //compraService.realizaCompra(compra);
        return compraServiceFeingClint.realizaCompra(compra);

    }
}
