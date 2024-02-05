package br.com.itau.geradornotafiscal.app.handler;

import br.com.itau.geradornotafiscal.in.exception.DocumentoValidationException;
import br.com.itau.geradornotafiscal.in.exception.PedidoValidationException;
import br.com.itau.geradornotafiscal.in.model.error.ErroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static br.com.itau.geradornotafiscal.in.util.Constants.*;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResponse handleValidationException(PedidoValidationException exception) {
        return new ErroResponse(VALOR_SOMA_ITENS_INVALIDO, CODE);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResponse handleValidationException(DocumentoValidationException exception) {
        return new ErroResponse(DOCUMENTO_INVALIDO, CPF_CNPJ);
    }
}