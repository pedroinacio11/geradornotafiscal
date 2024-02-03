package br.com.itau.geradornotafiscal.in.model;

import br.com.itau.geradornotafiscal.core.enums.TipoDocumento;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Documento {

    @JsonProperty("numero")
    private String numero;
    @JsonProperty("tipo")
    private TipoDocumento tipo;

}
