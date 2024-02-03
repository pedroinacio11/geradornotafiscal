package br.com.itau.geradornotafiscal.core.port;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;

public interface FinanceiroPort {

    void enviarNotaFiscalParaContasReceber(NotaFiscal notaFiscal);

}
