package br.com.itau.geradornotafiscal.in.model;

import br.com.itau.geradornotafiscal.core.enums.RegimeTributacaoPJ;
import br.com.itau.geradornotafiscal.core.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class Destinatario {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("tipo_pessoa")
    private TipoPessoa tipoPessoa;

    @JsonProperty("regime_tributacao")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private RegimeTributacaoPJ regimeTributacao;

    @JsonProperty("documentos")
    private List<Documento> documentos;

    @JsonProperty("enderecos")
    private List<Endereco> enderecos;

}




