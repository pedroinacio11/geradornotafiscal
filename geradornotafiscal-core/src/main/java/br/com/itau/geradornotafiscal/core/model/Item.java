package br.com.itau.geradornotafiscal.core.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Item {

    private String idItem;
    private String descricao;
    private double valorUnitario;
    private int quantidade;

}