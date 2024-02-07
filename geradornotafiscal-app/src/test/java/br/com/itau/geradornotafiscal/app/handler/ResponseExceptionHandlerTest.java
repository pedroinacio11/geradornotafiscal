package br.com.itau.geradornotafiscal.app.handler;

import br.com.itau.geradornotafiscal.core.exception.PedidoValidationException;
import br.com.itau.geradornotafiscal.in.controller.GeradorNFController;
import br.com.itau.geradornotafiscal.in.model.error.ErroResponse;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ResponseExceptionHandlerTest {
    @Mock
    private PedidoValidationException pedidoValidationException;

    @InjectMocks
    private GeradorNFController controller;


    @Test
    void pedidoValidationException_Test() {

        String mensagemEsperada = null;

        PedidoValidationException exception = assertThrows(PedidoValidationException.class, () -> {
            throw new PedidoValidationException();
        });

        // Assert
        assertEquals(mensagemEsperada, exception.getMessage());
    }
}