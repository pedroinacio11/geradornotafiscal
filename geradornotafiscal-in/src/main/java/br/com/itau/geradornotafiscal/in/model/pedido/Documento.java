package br.com.itau.geradornotafiscal.in.model.pedido;

import br.com.itau.geradornotafiscal.core.enums.TipoDocumento;
import br.com.itau.geradornotafiscal.in.exception.DocumentoValidationException;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import static br.com.itau.geradornotafiscal.core.enums.TipoDocumento.*;

@Data
public class Documento {

    @JsonProperty("numero")
    private String numero;

    @JsonProperty("tipo")
    private TipoDocumento tipo;

    public void setNumero(String numero) {
        if (!isValidNumero(numero)) {
            throw new DocumentoValidationException();
        }
        this.numero = numero;
        this.tipo = numero.length() == 11 ? CPF : CNPJ;
    }

    private boolean isValidNumero(String numero) {
        return numero != null && (numero.matches("\\d{11}") || numero.matches("\\d{14}"));
    }

}
