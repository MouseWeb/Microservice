package br.com.mouseweb.loja.openfeign;

import br.com.mouseweb.loja.controller.dto.CompraDTO;

public interface CompraServiceFeingClint {

    void realizaCompra(CompraDTO compra);

}
