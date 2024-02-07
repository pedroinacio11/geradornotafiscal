package br.com.itau.geradornotafiscal.app.handler;

import br.com.itau.geradornotafiscal.core.exception.DocumentoValidationException;
import br.com.itau.geradornotafiscal.core.exception.PedidoValidationException;
import br.com.itau.geradornotafiscal.core.exception.RegimeTributarioException;
import br.com.itau.geradornotafiscal.in.model.error.ErroResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static br.com.itau.geradornotafiscal.core.utils.Constants.*;

@Slf4j
@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResponse handleValidationException(PedidoValidationException exception) {
        log.error(PED_CODE + " - " + VALOR_SOMA_ITENS_INVALIDO, exception);
        return new ErroResponse(PED_CODE, VALOR_SOMA_ITENS_INVALIDO);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResponse handleValidationException(DocumentoValidationException exception) {
        log.error(CPF_CNPJ_CODE + " - " + DOCUMENTO_INVALIDO, exception);
        return new ErroResponse(CPF_CNPJ_CODE, DOCUMENTO_INVALIDO);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResponse handleValidationException(RegimeTributarioException exception) {
        log.error(REG_CODE + " - " + REGIME_TRIBUBTARIO_INVALIDO, exception);
        return new ErroResponse(REG_CODE, REGIME_TRIBUBTARIO_INVALIDO);
    }

}