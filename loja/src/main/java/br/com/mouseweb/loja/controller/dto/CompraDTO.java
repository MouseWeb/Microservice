package br.com.mouseweb.loja.controller.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompraDTO {

    private List<ItemDaCompraDTO> itens;

    private EnderecoDTO endereco;

}
