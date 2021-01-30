package br.com.mouseweb.fornecedor.service;

import br.com.mouseweb.fornecedor.entity.InfoFornecedor;

public interface InfoService {

    InfoFornecedor getInfoPorEstado(String estado);

}
