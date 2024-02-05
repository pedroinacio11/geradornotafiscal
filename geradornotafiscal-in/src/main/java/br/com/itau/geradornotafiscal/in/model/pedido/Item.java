package br.com.itau.geradornotafiscal.in.model.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Item {

    @NotNull
    @NotEmpty
    @JsonProperty("id_item")
    private String idItem;

    @NotNull
    @NotEmpty
    @JsonProperty("descricao")
    private String descricao;

    @NotNull
    @JsonProperty("valor_unitario")
    private double valorUnitario;

    @Size(min = 1)
    @JsonProperty("quantidade")
    private int quantidade;


}

