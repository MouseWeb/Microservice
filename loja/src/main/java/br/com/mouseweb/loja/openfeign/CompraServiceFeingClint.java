package br.com.mouseweb.loja.openfeign;

import br.com.mouseweb.loja.dto.CompraDTO;
import br.com.mouseweb.loja.entity.Compra;

public interface CompraServiceFeingClint {

    Compra realizaCompra(CompraDTO compra);

    Compra getById(Long id);
}
