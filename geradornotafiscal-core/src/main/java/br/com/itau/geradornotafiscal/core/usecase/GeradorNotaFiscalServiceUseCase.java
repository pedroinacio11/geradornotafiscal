package br.com.itau.geradornotafiscal.core.usecase;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.model.Pedido;

public interface GeradorNotaFiscalServiceUseCase {

    NotaFiscal gerarNotaFiscal(Pedido pedido);

}
