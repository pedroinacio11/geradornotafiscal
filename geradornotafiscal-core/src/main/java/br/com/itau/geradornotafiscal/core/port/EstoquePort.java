package br.com.itau.geradornotafiscal.core.port;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;

public interface EstoquePort {

    void enviarNotaFiscalParaBaixaEstoque(NotaFiscal notaFiscal);

}
