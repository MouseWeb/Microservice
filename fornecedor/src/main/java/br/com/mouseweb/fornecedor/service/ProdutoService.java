package br.com.mouseweb.fornecedor.service;

import br.com.mouseweb.fornecedor.entity.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> getProdutosPorEstado(String estado);

}
