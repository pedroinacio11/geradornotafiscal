package br.com.itau.geradornotafiscal.out;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.port.AgendamentoPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgendamentoAdapterTest {
    @Test
    void testAgendarEntrega() {


        AgendamentoPort agendamento = new AgendamentoAdapter();
        NotaFiscal notaFiscal = new NotaFiscal();

        assertDoesNotThrow(() -> {
            long startTime = System.currentTimeMillis();
            agendamento.agendarEntrega(notaFiscal);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            assertTrue(elapsedTime >= 150);
        });
    }

    @Test
    void testCriarAgendamentoEntrega() {

        AgendamentoPort agendamento = new AgendamentoAdapter();
        NotaFiscal notaFiscal = new NotaFiscal();

        assertDoesNotThrow(() -> {
            long startTime = System.currentTimeMillis();
            agendamento.criarAgendamentoEntrega(notaFiscal);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            assertTrue(elapsedTime >= 200);
        });
    }
}