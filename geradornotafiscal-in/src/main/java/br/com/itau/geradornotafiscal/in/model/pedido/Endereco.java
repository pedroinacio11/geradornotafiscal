package br.com.itau.geradornotafiscal.in.model.pedido;

import br.com.itau.geradornotafiscal.core.enums.Finalidade;
import br.com.itau.geradornotafiscal.core.enums.Regiao;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class Endereco {

    @NotNull
    @NotBlank
    @JsonProperty("cep")
    private String cep;

    @NotNull
    @NotBlank
    @JsonProperty("logradouro")
    private String logradouro;

    @NotNull
    @NotBlank
    @JsonProperty("numero")
    private String numero;

    @NotNull
    @NotBlank
    @JsonProperty("estado")
    private String estado;

    @JsonProperty("complemento")
    private String complemento;

    @NotNull
    @NotBlank
    @JsonProperty("finalidade")
    private Finalidade finalidade;

    @NotNull
    @NotBlank
    @JsonProperty("regiao")
    private Regiao regiao;
}