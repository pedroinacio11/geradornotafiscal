package br.com.itau.geradornotafiscal.out;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.port.RegistroPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroAdapterTest {

    @Test
    void testRegistrarNotaFiscal() {

        RegistroPort registro = new RegistroAdapter();
        NotaFiscal notaFiscal = new NotaFiscal();

        assertDoesNotThrow(() -> {
            long startTime = System.currentTimeMillis();
            registro.RegistrarNotaFiscal(notaFiscal);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            assertTrue(elapsedTime >= 500);
        });
    }
}