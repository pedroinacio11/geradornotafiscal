package br.com.itau.geradornotafiscal.core.validator;

import br.com.itau.geradornotafiscal.core.exception.ValorFreteInvalidoException;
import br.com.itau.geradornotafiscal.core.exception.ValorFreteMuitoAltoException;
import br.com.itau.geradornotafiscal.core.exception.ValorFreteZeroException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ValorFreteValidator {

    public void validarValorFrete(double valorFrete) {
        if (valorFrete < 0) {
            throw new ValorFreteInvalidoException();
        }
        if (valorFrete == 0) {
            throw new ValorFreteZeroException();
        }
        if (valorFrete > 10000) {
            throw new ValorFreteMuitoAltoException();
        }
    }

}
