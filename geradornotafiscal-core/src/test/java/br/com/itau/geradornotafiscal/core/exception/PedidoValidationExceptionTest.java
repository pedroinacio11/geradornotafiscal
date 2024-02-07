package br.com.itau.geradornotafiscal.core.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PedidoValidationExceptionTest {

    @Test
    void testConstructor() {
        PedidoValidationException exception = new PedidoValidationException();
        assertNotNull(exception);
    }

    @Test
    void testMessage() {
        PedidoValidationException exception = new PedidoValidationException();
        assertNull(exception.getMessage());
    }
}