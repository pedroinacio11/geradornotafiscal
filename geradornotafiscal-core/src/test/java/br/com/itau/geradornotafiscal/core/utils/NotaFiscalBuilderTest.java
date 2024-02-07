package br.com.itau.geradornotafiscal.core.utils;

import br.com.itau.geradornotafiscal.core.enums.RegimeTributacao;
import br.com.itau.geradornotafiscal.core.enums.TipoPessoa;
import br.com.itau.geradornotafiscal.core.model.Destinatario;
import br.com.itau.geradornotafiscal.core.model.ItemNotaFiscal;
import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.model.Pedido;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotaFiscalBuilderTest {

    @Test
    void testBuildNotaFiscal() {

        Pedido pedido = new Pedido();
        pedido.setValorTotalItens(500.0);

        Destinatario destinatario = new Destinatario();
        destinatario.setNome("Pedro Henrique");
        destinatario.setTipoPessoa(TipoPessoa.FISICA);
        destinatario.setRegimeTributacao(RegimeTributacao.SIMPLES_NACIONAL);

        pedido.setDestinatario(destinatario);

        double valorFreteComPercentual = 50.0;
        List<ItemNotaFiscal> itemNotaFiscalList = new ArrayList<>();

        NotaFiscal notaFiscal = NotaFiscalBuilder.buildNotaFiscal(pedido, valorFreteComPercentual, itemNotaFiscalList);

        assertNotNull(notaFiscal.getIdNotaFiscal());
        assertEquals(pedido.getValorTotalItens(), notaFiscal.getValorTotalItens());
        assertEquals(valorFreteComPercentual, notaFiscal.getValorFrete());
        assertEquals(itemNotaFiscalList, notaFiscal.getItens());
        assertEquals(pedido.getDestinatario(), notaFiscal.getDestinatario());
    }
}