package br.com.mouseweb.loja.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InfoEntregaDTO {

    private Long pedidoId;

    private LocalDate dataParaEntrega;

    private String enderecoOrigem;

    private String enderecoDestino;

}
