package br.com.itau.geradornotafiscal.core.utils;

import br.com.itau.geradornotafiscal.core.model.ItemNotaFiscal;
import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.model.Pedido;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class NotaFiscalBuilder {

    public static NotaFiscal buildNotaFiscal(Pedido pedido,
                                             double valorFreteComPercentual,
                                             List<ItemNotaFiscal> itemNotaFiscalList) {
        return NotaFiscal.builder()
                .idNotaFiscal(UUID.randomUUID().toString())
                .data(LocalDateTime.now())
                .valorTotalItens(pedido.getValorTotalItens())
                .valorFrete(valorFreteComPercentual)
                .itens(itemNotaFiscalList)
                .destinatario(pedido.getDestinatario())
                .build();
    }

}
