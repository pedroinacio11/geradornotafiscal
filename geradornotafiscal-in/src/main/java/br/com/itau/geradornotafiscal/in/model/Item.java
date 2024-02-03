package br.com.itau.geradornotafiscal.in.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Item {
    @JsonProperty("id_item")
    private String idItem;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("valor_unitario")
    private double valorUnitario;

    @JsonProperty("quantidade")
    private int quantidade;


}

