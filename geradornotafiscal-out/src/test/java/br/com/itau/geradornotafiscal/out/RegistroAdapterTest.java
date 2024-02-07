package br.com.itau.geradornotafiscal.out;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.port.RegistroPort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistroAdapterTest {

    @Test
    void testRegistrarNotaFiscal() {
        // Arrange
        RegistroPort registro = new RegistroAdapter();
        NotaFiscal notaFiscal = new NotaFiscal(); // Criar uma nota fiscal de exemplo

        // Act & Assert
        assertDoesNotThrow(() -> {
            long startTime = System.currentTimeMillis();
            registro.RegistrarNotaFiscal(notaFiscal);
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            assertTrue(elapsedTime >= 500); // Verificar se o tempo de execução é pelo menos 500ms
        });
    }
}