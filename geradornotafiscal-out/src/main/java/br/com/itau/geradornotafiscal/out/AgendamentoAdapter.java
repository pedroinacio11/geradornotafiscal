package br.com.itau.geradornotafiscal.out;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.port.AgendamentoPort;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoAdapter implements AgendamentoPort {
    @Override
    public void agendarEntrega(NotaFiscal notaFiscal) {
        try {
            //Simula o agendamento da entrega
            Thread.sleep(150);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void criarAgendamentoEntrega(NotaFiscal notaFiscal) {
        try {
            //Simula o agendamento da entrega
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
