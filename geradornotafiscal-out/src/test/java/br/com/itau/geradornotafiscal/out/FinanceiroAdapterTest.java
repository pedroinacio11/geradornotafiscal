package br.com.itau.geradornotafiscal.out;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.port.FinanceiroPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FinanceiroAdapterTest {

    @Test
    void testEnviarNotaFiscalParaContasReceber() {
        // Arrange
        FinanceiroPort financeiro = new FinanceiroAdapter();
        NotaFiscal notaFiscal = new NotaFiscal();

        // Act & Assert
        assertDoesNotThrow(() -> {
            long startTime = System.currentTimeMillis();
            financeiro.enviarNotaFiscalParaContasReceber(notaFiscal);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            assertTrue(elapsedTime >= 250);
        });
    }
}