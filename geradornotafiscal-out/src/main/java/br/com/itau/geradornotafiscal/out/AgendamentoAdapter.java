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
            if (notaFiscal.getItens().size() > 5) {
                    /* Aqui está o problema de performance do aplicacao para pedidos com mais de 5 itens
                        Se voce chegou ate aqui basta remover esse valor de 5s para 'solucionar' o misterio
                    * */
                Thread.sleep(5000);
            }
            Thread.sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
