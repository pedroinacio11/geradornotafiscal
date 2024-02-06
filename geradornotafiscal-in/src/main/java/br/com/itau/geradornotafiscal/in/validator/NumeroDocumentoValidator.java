package br.com.itau.geradornotafiscal.in.validator;

import br.com.itau.geradornotafiscal.core.exception.DocumentoValidationException;

public class NumeroDocumentoValidator {

    public String getDocumento(String documento) {

        if (!isValidNumero(documento)) {
            throw new DocumentoValidationException();
        }

        return documento;
    }

    public static boolean isValidNumero(String numero) {
        return numero != null && (numero.matches("\\d{11}") || numero.matches("\\d{14}"));
    }
    
}
