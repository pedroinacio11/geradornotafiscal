package br.com.itau.geradornotafiscal.core.service;

import br.com.itau.geradornotafiscal.core.enums.Finalidade;
import br.com.itau.geradornotafiscal.core.enums.Regiao;
import br.com.itau.geradornotafiscal.core.enums.RegimeTributacaoPJ;
import br.com.itau.geradornotafiscal.core.enums.TipoPessoa;
import br.com.itau.geradornotafiscal.core.model.*;
import br.com.itau.geradornotafiscal.core.port.AgendamentoPort;
import br.com.itau.geradornotafiscal.core.port.EstoquePort;
import br.com.itau.geradornotafiscal.core.port.FinanceiroPort;
import br.com.itau.geradornotafiscal.core.port.RegistroPort;
import br.com.itau.geradornotafiscal.core.usecase.GeradorNotaFiscalServiceUseCase;
import br.com.itau.geradornotafiscal.core.utils.ObterAliquota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class GeradorNotaFiscalService implements GeradorNotaFiscalServiceUseCase {

    @Autowired
    private AgendamentoPort agendamentoPort;

    @Autowired
    private EstoquePort estoquePort;

    @Autowired
    private RegistroPort registroPort;

    @Autowired
    private FinanceiroPort financeiroPort;

    @Override
    public NotaFiscal gerarNotaFiscal(Pedido pedido) {

        Destinatario destinatario = pedido.getDestinatario();
        TipoPessoa tipoPessoa = destinatario.getTipoPessoa();
        List<ItemNotaFiscal> itemNotaFiscalList = new ArrayList<>();

        CalculadoraAliquotaProduto calculadoraAliquotaProduto = new CalculadoraAliquotaProduto();

        switch (tipoPessoa) {
            case FISICA -> {
                double valorTotalItens = pedido.getValorTotalItens();
                double aliquota = new ObterAliquota().pessoaFisica(valorTotalItens);
                itemNotaFiscalList = calculadoraAliquotaProduto.calcularAliquota(pedido.getItens(), aliquota);
            }
            case JURIDICA -> {
                RegimeTributacaoPJ regimeTributacao = destinatario.getRegimeTributacao();
                double valorTotalItens = pedido.getValorTotalItens();
                double aliquota = new ObterAliquota().pessoaJuridica(valorTotalItens, regimeTributacao);
                itemNotaFiscalList = calculadoraAliquotaProduto.calcularAliquota(pedido.getItens(), aliquota);
            }
        }
        //Regras diferentes para frete

        Regiao regiao = destinatario.getEnderecos().stream()
                .filter(endereco -> endereco.getFinalidade() == Finalidade.ENTREGA || endereco.getFinalidade() == Finalidade.COBRANCA_ENTREGA)
                .map(Endereco::getRegiao)
                .findFirst()
                .orElse(null);

        double valorFrete = pedido.getValorFrete();
        double valorFreteComPercentual = 0;

        if (regiao == Regiao.NORTE) {
            valorFreteComPercentual = valorFrete * 1.08;
        } else if (regiao == Regiao.NORDESTE) {
            valorFreteComPercentual = valorFrete * 1.085;
        } else if (regiao == Regiao.CENTRO_OESTE) {
            valorFreteComPercentual = valorFrete * 1.07;
        } else if (regiao == Regiao.SUDESTE) {
            valorFreteComPercentual = valorFrete * 1.048;
        } else if (regiao == Regiao.SUL) {
            valorFreteComPercentual = valorFrete * 1.06;
        }

        // Create the NotaFiscal object
        String idNotaFiscal = UUID.randomUUID().toString();

        NotaFiscal notaFiscal = NotaFiscal.builder()
                .idNotaFiscal(idNotaFiscal)
                .data(LocalDateTime.now())
                .valorTotalItens(pedido.getValorTotalItens())
                .valorFrete(valorFreteComPercentual)
                .itens(itemNotaFiscalList)
                .destinatario(pedido.getDestinatario())
                .build();

        estoquePort.enviarNotaFiscalParaBaixaEstoque(notaFiscal);
        registroPort.RegistrarNotaFiscal(notaFiscal);
        agendamentoPort.agendarEntrega(notaFiscal);
        agendamentoPort.criarAgendamentoEntrega(notaFiscal);
        financeiroPort.enviarNotaFiscalParaContasReceber(notaFiscal);

        return notaFiscal;

    }
}
