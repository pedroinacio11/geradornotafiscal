package br.com.itau.geradornotafiscal.in.model;

import br.com.itau.geradornotafiscal.core.enums.Finalidade;
import br.com.itau.geradornotafiscal.core.enums.Regiao;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Endereco {

    @JsonProperty("cep")
    private String cep;

    @JsonProperty("logradouro")
    private String logradouro;

    @JsonProperty("numero")
    private String numero;

    @JsonProperty("estado")
    private String estado;

    @JsonProperty("complemento")
    private String complemento;

    @JsonProperty("finalidade")
    private Finalidade finalidade;

    @JsonProperty("regiao")
    private Regiao regiao;
}