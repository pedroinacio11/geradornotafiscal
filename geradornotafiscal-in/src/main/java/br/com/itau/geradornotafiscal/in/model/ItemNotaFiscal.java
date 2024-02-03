package br.com.itau.geradornotafiscal.in.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemNotaFiscal {
    @JsonProperty("id_item")
    private String idItem;

    @JsonProperty("descricao")
    private String descricao;

    @JsonProperty("valor_unitario")
    private double valorUnitario;

    @JsonProperty("quantidade")
    private int quantidade;

    @JsonProperty("valor_tributo_item")
    private double valorTributoItem;

}