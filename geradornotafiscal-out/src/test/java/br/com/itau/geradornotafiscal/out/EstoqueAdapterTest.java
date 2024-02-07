package br.com.itau.geradornotafiscal.out;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.port.EstoquePort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EstoqueAdapterTest {

    @Test
    void testEnviarNotaFiscalParaBaixaEstoque() {

        EstoquePort estoque = new EstoqueAdapter();
        NotaFiscal notaFiscal = new NotaFiscal();

        assertDoesNotThrow(() -> {
            long startTime = System.currentTimeMillis();
            estoque.enviarNotaFiscalParaBaixaEstoque(notaFiscal);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            assertTrue(elapsedTime >= 380);
        });
    }
}