package br.com.itau.geradornotafiscal.out;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.port.FinanceiroPort;
import org.springframework.stereotype.Service;

@Service
public class FinanceiroAdapter implements FinanceiroPort {
    @Override
    public void enviarNotaFiscalParaContasReceber(NotaFiscal notaFiscal) {
        try {
            //Simula o envio da nota fiscal para o contas a receber
            Thread.sleep(250);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
