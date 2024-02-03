package br.com.itau.geradornotafiscal.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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