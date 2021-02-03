package br.com.mouseweb.loja.entity;

import lombok.Data;

@Data
public class Compra {

    private Long pedido;

    private Integer tempoDePreparo;

    private String enderecoDestino;

}
