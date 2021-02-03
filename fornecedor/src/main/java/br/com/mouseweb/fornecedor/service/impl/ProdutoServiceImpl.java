package br.com.mouseweb.fornecedor.service.impl;

import java.util.List;

import br.com.mouseweb.fornecedor.entity.Produto;
import br.com.mouseweb.fornecedor.repository.ProdutoRepository;
import br.com.mouseweb.fornecedor.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> getProdutosPorEstado(String estado) {
        return produtoRepository.findByEstado(estado);
    }

}
