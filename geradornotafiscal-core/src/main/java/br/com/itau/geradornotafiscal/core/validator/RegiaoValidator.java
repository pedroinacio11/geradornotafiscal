package br.com.itau.geradornotafiscal.core.validator;

import br.com.itau.geradornotafiscal.core.enums.Regiao;
import br.com.itau.geradornotafiscal.core.exception.RegiaoEntregaInvalidaException;
import org.springframework.stereotype.Component;

@Component
public class RegiaoValidator {

    public void validarRegiaoEntrega(Regiao regiaoEntrega) {
        if (regiaoEntrega == null) {
            throw new RegiaoEntregaInvalidaException();
        }
    }

}
