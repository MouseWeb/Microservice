package br.com.mouseweb.loja.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.List;

@Data
public class CompraDTO {

    @JsonIgnore
    private Long compraId;

    private List<ItemDaCompraDTO> itens;

    private EnderecoDTO endereco;

}
