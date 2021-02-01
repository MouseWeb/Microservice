package br.com.mouseweb.loja.service.impl;

import br.com.mouseweb.loja.controller.dto.CompraDTO;
import br.com.mouseweb.loja.controller.dto.InfoFornecedorDTO;
import br.com.mouseweb.loja.service.CompraService;
import br.com.mouseweb.loja.util.Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CompraServiceImpl implements CompraService {

    private final Logger log = LoggerFactory.getLogger(CompraServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    Endpoint endpoint;

    public void realizaCompra(CompraDTO compra) {
        ResponseEntity<InfoFornecedorDTO> exchange = new ResponseEntity<> (HttpStatus.NO_CONTENT);
        exchange = this.restTemplate.exchange(endpoint.getFornecedorInfo() +
                compra.getEndereco().getEstado(),
                HttpMethod.GET,
                null,
                InfoFornecedorDTO.class);

        log.info(exchange.getBody().getEndereco());

    }

    /*public void realizaCompra(CompraDTO compra) {
        ResponseEntity<InfoFornecedorDTO> exchange = new ResponseEntity<> (HttpStatus.NO_CONTENT);
        Map<String, Object> uriParams = new HashMap<>();
        uriParams.put("estado", compra.getEndereco().getEstado());

        exchange = this.restTemplate.exchange(endpoint.getFornecedorInfo(),
                HttpMethod.GET,
                null,
                InfoFornecedorDTO.class, uriParams);

        log.info(exchange.getBody().getEndereco());

    }*/

}
