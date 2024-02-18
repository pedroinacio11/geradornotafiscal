package br.com.itau.geradornotafiscal.core.service;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.model.Pedido;
import br.com.itau.geradornotafiscal.core.port.AgendamentoPort;
import br.com.itau.geradornotafiscal.core.port.EstoquePort;
import br.com.itau.geradornotafiscal.core.port.FinanceiroPort;
import br.com.itau.geradornotafiscal.core.port.RegistroPort;
import br.com.itau.geradornotafiscal.core.usecase.GeradorNotaFiscalServiceUseCase;
import br.com.itau.geradornotafiscal.core.utils.NotaFiscalBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GerarNotaFiscalServiceImpl implements GeradorNotaFiscalServiceUseCase {

    @Autowired
    private AgendamentoPort agendamentoPort;

    @Autowired
    private EstoquePort estoquePort;

    @Autowired
    private RegistroPort registroPort;

    @Autowired
    private FinanceiroPort financeiroPort;

    @Autowired
    private CalcularAliquotaTipoPessoaService calcularAliquotaTipoPessoaService;

    @Autowired
    private CalcularAliquotaProdutoService calcularAliquotaProdutoService;

    @Autowired
    private CalcularFreteService calcularFreteService;

    @Override
    public NotaFiscal gerarNotaFiscal(Pedido pedido) {

        var valorFrete = calcularFreteService.calcularValorFreteComPercentual(pedido);
        var valorAliquotaPessoa = calcularAliquotaTipoPessoaService.obterAliquota(pedido);
        var valorAliquotaProduto = calcularAliquotaProdutoService.calcularAliquotaProduto(pedido, valorAliquotaPessoa);

        var notaFiscal = NotaFiscalBuilder.buildNotaFiscal(pedido, valorFrete, valorAliquotaProduto);

        estoquePort.enviarNotaFiscalParaBaixaEstoque(notaFiscal);
        registroPort.RegistrarNotaFiscal(notaFiscal);
        agendamentoPort.agendarEntrega(notaFiscal);
        agendamentoPort.criarAgendamentoEntrega(notaFiscal);
        financeiroPort.enviarNotaFiscalParaContasReceber(notaFiscal);

        return notaFiscal;
    }
}
