package br.com.itau.geradornotafiscal.in.model.pedido;

import br.com.itau.geradornotafiscal.core.enums.RegimeTributacaoPJ;
import br.com.itau.geradornotafiscal.core.enums.TipoPessoa;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Data
public class Destinatario {

    @NotNull
    @NotEmpty
    @JsonProperty("nome")
    private String nome;

    @NotNull
    @NotEmpty
    @JsonProperty("tipo_pessoa")
    private TipoPessoa tipoPessoa;

    @NotNull
    @NotEmpty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("regime_tributacao")
    private RegimeTributacaoPJ regimeTributacao;

    @NotNull
    @Size(min = 1)
    @JsonProperty("documentos")
    private List<Documento> documentos;

    @NotNull
    @Size(min = 1)
    @JsonProperty("enderecos")
    private List<Endereco> enderecos;

}




