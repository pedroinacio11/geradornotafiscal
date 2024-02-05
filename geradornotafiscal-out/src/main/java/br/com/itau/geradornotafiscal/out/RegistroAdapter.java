package br.com.itau.geradornotafiscal.out;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.port.RegistroPort;
import org.springframework.stereotype.Service;

@Service
public class RegistroAdapter implements RegistroPort {
    @Override
    public void RegistrarNotaFiscal(NotaFiscal notaFiscal) {
        try {
            //Simula o registro da nota fiscal
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
