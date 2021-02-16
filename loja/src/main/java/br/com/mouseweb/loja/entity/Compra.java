package br.com.mouseweb.loja.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Compra {

    @Id
    private Long pedido;

    private Integer tempoDePreparo;

    private String enderecoDestino;

}
