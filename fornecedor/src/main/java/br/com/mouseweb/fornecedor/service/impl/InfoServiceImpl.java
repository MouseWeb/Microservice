package br.com.mouseweb.fornecedor.service.impl;

import br.com.mouseweb.fornecedor.entity.InfoFornecedor;
import br.com.mouseweb.fornecedor.repository.InfoRepository;
import br.com.mouseweb.fornecedor.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private InfoRepository infoRepository;

    public InfoFornecedor getInfoPorEstado(String estado) {
        return infoRepository.findByEstado(estado);
    }
}
