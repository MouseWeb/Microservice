package br.com.mouseweb.loja.entity;

import br.com.mouseweb.loja.enums.CompraState;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pedido;

    private Integer tempoDePreparo;

    private String enderecoDestino;

    private LocalDate dataParaEntrega;

    private Long voucher;

    @Enumerated(EnumType.STRING)
    private CompraState state;

}
