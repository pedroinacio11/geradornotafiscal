package br.com.itau.geradornotafiscal.core.port;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;

public interface AgendamentoPort {

    void agendarEntrega(NotaFiscal notaFiscal);
    void criarAgendamentoEntrega(NotaFiscal notaFiscal);

}
