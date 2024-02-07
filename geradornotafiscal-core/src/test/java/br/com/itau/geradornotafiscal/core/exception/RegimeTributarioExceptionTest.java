package br.com.itau.geradornotafiscal.core.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegimeTributarioExceptionTest {

    @Test
    void testConstructor() {
        RegimeTributarioException exception = new RegimeTributarioException();
        assertNotNull(exception);
    }

    @Test
    void testMessage() {
        RegimeTributarioException exception = new RegimeTributarioException();
        assertNull(exception.getMessage());
    }
}