package br.com.itau.geradornotafiscal.in.model.error;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErroResponseTest {

    @Test
    void erroResponse_Test() {

        String code = "CODE001";
        String message = "Mensagem de erro";

        ErroResponse erroResponse = new ErroResponse(code, message);

        assertEquals(code, erroResponse.getCode());
        assertEquals(message, erroResponse.getMessage());
    }
}