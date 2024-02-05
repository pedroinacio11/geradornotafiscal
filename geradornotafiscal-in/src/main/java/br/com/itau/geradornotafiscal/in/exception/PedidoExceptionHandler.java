package br.com.itau.geradornotafiscal.in.exception;

import br.com.itau.geradornotafiscal.in.model.ErroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static br.com.itau.geradornotafiscal.in.util.Constants.CODE;
import static br.com.itau.geradornotafiscal.in.util.Constants.VALOR_SOMA_ITENS_INVALIDO;


@RestControllerAdvice
public class PedidoExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResponse handleValidationException(PedidoValidationException exception) {
        return new ErroResponse(VALOR_SOMA_ITENS_INVALIDO, CODE);
    }
}