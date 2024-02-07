package br.com.itau.geradornotafiscal.in.validator;

import br.com.itau.geradornotafiscal.core.exception.DocumentoValidationException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumeroDocumentoValidatorTest {

    @Test
    void testGetDocumento_ValidDocument() {

        String validDocument = "12345678901";
        NumeroDocumentoValidator validator = new NumeroDocumentoValidator();

        String result = validator.getDocumento(validDocument);

        assertEquals(validDocument, result);
    }

    @Test
    void testGetDocumento_InvalidDocument() {

        String invalidDocument = "12345";
        NumeroDocumentoValidator validator = new NumeroDocumentoValidator();

        assertThrows(DocumentoValidationException.class, () -> {
            validator.getDocumento(invalidDocument);
        });
    }

    @Test
    void testIsValidNumero_ValidDocument() {

        String validDocument = "12345678901";
        NumeroDocumentoValidator validator = new NumeroDocumentoValidator();

        boolean isValid = validator.isValidNumero(validDocument);

        assertTrue(isValid);
    }

    @Test
    void testIsValidNumero_InvalidDocument() {

        String invalidDocument = "12345"; // Número de documento inválido
        NumeroDocumentoValidator validator = new NumeroDocumentoValidator();

        boolean isValid = validator.isValidNumero(invalidDocument);

        assertFalse(isValid);
    }
}