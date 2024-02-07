package br.com.itau.geradornotafiscal.in.model.pedido;

import br.com.itau.geradornotafiscal.core.enums.TipoDocumento;
import br.com.itau.geradornotafiscal.in.validator.NumeroDocumentoValidator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import static br.com.itau.geradornotafiscal.core.enums.TipoDocumento.CNPJ;
import static br.com.itau.geradornotafiscal.core.enums.TipoDocumento.CPF;

@Data
public class Documento {

    @JsonProperty("numero")
    private String numero;

    @JsonProperty("tipo")
    private TipoDocumento tipo;

    public void setNumero(String numero) {

        NumeroDocumentoValidator numeroDocumentoValidator = new NumeroDocumentoValidator();
        this.numero = numeroDocumentoValidator.getDocumento(numero);
        this.tipo = numero.length() == 11 ? CPF : CNPJ;
    }


}
