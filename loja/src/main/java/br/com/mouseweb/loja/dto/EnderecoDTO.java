package br.com.mouseweb.loja.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class EnderecoDTO {

    private String rua;
    private int numero;
    private String estado;

}
