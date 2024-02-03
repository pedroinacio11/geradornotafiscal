package br.com.itau.geradornotafiscal.core.service;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.port.out.EntregaIntegrationPort;

public class EntregaService {
    public void agendarEntrega(NotaFiscal notaFiscal) {

        try {
            //Simula o agendamento da entrega
            Thread.sleep(150);
            new EntregaIntegrationPort().criarAgendamentoEntrega(notaFiscal);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
