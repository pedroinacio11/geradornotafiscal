package br.com.itau.geradornotafiscal.core.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DocumentoValidationExceptionTest {
    @Test
    void testConstructor() {
        DocumentoValidationException exception = new DocumentoValidationException();
        assertNotNull(exception);
    }

    @Test
    void testMessage() {
        DocumentoValidationException exception = new DocumentoValidationException();
        assertNull(exception.getMessage());
    }
}
