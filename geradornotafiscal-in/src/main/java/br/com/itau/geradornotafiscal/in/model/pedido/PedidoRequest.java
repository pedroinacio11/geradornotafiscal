package br.com.itau.geradornotafiscal.in.model.pedido;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
public class PedidoRequest {

    @NotNull(message = "O id do pedido é obrigatório")
    @JsonProperty("id_pedido")
    private int idPedido;

    @JsonProperty("data")
    private LocalDate data;

    @NotNull
    @JsonProperty("valor_total_itens")
    private double valorTotalItens;

    @PositiveOrZero(message = "O valor do frete deve ser maior ou igual a zero")
    @JsonProperty("valor_frete")
    private double valorFrete;

    @NotNull
    @Size(min = 1)
    @JsonProperty("itens")
    private List<Item> itens;

    @NotNull
    @JsonProperty("destinatario")
    private Destinatario destinatario;

}
