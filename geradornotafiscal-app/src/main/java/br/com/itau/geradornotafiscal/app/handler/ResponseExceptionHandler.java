package br.com.itau.geradornotafiscal.app.handler;

import br.com.itau.geradornotafiscal.core.exception.DocumentoValidationException;
import br.com.itau.geradornotafiscal.core.exception.PedidoValidationException;
import br.com.itau.geradornotafiscal.core.exception.RegimeTributarioException;
import br.com.itau.geradornotafiscal.in.model.error.ErroResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static br.com.itau.geradornotafiscal.core.utils.Constants.*;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResponse handleValidationException(PedidoValidationException exception) {
        return new ErroResponse(VALOR_SOMA_ITENS_INVALIDO, PED_CODE);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResponse handleValidationException(DocumentoValidationException exception) {
        return new ErroResponse(DOCUMENTO_INVALIDO, CPF_CNPJ_CODE);
    }
    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResponse handleValidationException(RegimeTributarioException exception) {
        return new ErroResponse(REGIME_TRIBUBTARIO_INVALIDO, REG_CODE);
    }
}