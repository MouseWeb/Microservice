package br.com.mouseweb.loja.openfeign;

import br.com.mouseweb.loja.controller.dto.CompraDTO;
import br.com.mouseweb.loja.entity.Compra;

public interface CompraServiceFeingClint {

    Compra realizaCompra(CompraDTO compra);

}
