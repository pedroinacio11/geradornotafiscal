package br.com.itau.geradornotafiscal.core.service.impl;

import br.com.itau.geradornotafiscal.core.enums.Finalidade;
import br.com.itau.geradornotafiscal.core.enums.Regiao;
import br.com.itau.geradornotafiscal.core.enums.RegimeTributacaoPJ;
import br.com.itau.geradornotafiscal.core.enums.TipoPessoa;
import br.com.itau.geradornotafiscal.core.model.*;
import br.com.itau.geradornotafiscal.core.port.AgendamentoPort;
import br.com.itau.geradornotafiscal.core.port.EstoquePort;
import br.com.itau.geradornotafiscal.core.port.FinanceiroPort;
import br.com.itau.geradornotafiscal.core.port.RegistroPort;
import br.com.itau.geradornotafiscal.core.service.CalcularAliquotaProdutoService;
import br.com.itau.geradornotafiscal.core.service.CalcularAliquotaTipoPessoaService;
import br.com.itau.geradornotafiscal.core.service.CalcularFreteService;
import br.com.itau.geradornotafiscal.core.service.GerarNotaFiscalServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GerarNotaFiscalServiceImplTest {

    @Mock
    private AgendamentoPort agendamentoPort;

    @Mock
    private EstoquePort estoquePort;

    @Mock
    private RegistroPort registroPort;

    @Mock
    private FinanceiroPort financeiroPort;

    @Mock
    private CalcularAliquotaTipoPessoaService calcularAliquotaTipoPessoaService;

    @Mock
    private CalcularAliquotaProdutoService calcularAliquotaProdutoService;

    @Mock
    private CalcularFreteService calcularFreteService;

    @InjectMocks
    private GerarNotaFiscalServiceImpl gerarNotaFiscalService;

    @Test
    void shouldGenerateNotaFiscalForTipoPessoaFisicaWithValorTotalItensLessThan500() {

        Pedido pedido = new Pedido();
        pedido.setValorTotalItens(400.0);
        pedido.setValorFrete(100);

        Destinatario destinatario = new Destinatario();
        destinatario.setTipoPessoa(TipoPessoa.JURIDICA);
        destinatario.setRegimeTributacao(RegimeTributacaoPJ.SIMPLES_NACIONAL);

        Endereco endereco = new Endereco();
        endereco.setFinalidade(Finalidade.ENTREGA);
        endereco.setRegiao(Regiao.SUDESTE);
        destinatario.setEnderecos(Arrays.asList(endereco));

        pedido.setDestinatario(destinatario);

        List<ItemNotaFiscal> itens = new ArrayList<>();

        var qtditens = 2;

        for (int i = 0; i < qtditens; i++) {
            ItemNotaFiscal item = new ItemNotaFiscal();
            item.setValorUnitario(5);
            item.setQuantidade(4);
            itens.add(item);
        }

        when(calcularAliquotaProdutoService.calcularAliquotaProduto(any(), anyDouble())).thenReturn(itens);
        when(calcularFreteService.calcularValorFreteComPercentual(pedido)).thenReturn(100.0);

        NotaFiscal notaFiscalGerada = gerarNotaFiscalService.gerarNotaFiscal(pedido);

        assertEquals(pedido.getValorTotalItens(), notaFiscalGerada.getValorTotalItens());
        assertEquals(2, notaFiscalGerada.getItens().size());
        assertEquals(0, notaFiscalGerada.getItens().get(0).getValorTributoItem());

        verify(estoquePort).enviarNotaFiscalParaBaixaEstoque(notaFiscalGerada);
        verify(registroPort).RegistrarNotaFiscal(notaFiscalGerada);
        verify(agendamentoPort).agendarEntrega(notaFiscalGerada);
        verify(agendamentoPort).criarAgendamentoEntrega(notaFiscalGerada);
        verify(financeiroPort).enviarNotaFiscalParaContasReceber(notaFiscalGerada);
    }

}
