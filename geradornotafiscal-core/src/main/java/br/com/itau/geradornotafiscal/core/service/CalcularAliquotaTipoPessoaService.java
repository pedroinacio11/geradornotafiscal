package br.com.itau.geradornotafiscal.core.service;

import br.com.itau.geradornotafiscal.core.enums.RegimeTributacao;
import br.com.itau.geradornotafiscal.core.exception.RegimeTributarioException;
import br.com.itau.geradornotafiscal.core.model.Pedido;
import br.com.itau.geradornotafiscal.core.port.CalculoImpostoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcularAliquotaTipoPessoaService {


    @Autowired
    private CalculoImpostoPort calculoImpostoPort;

    public double obterAliquota(Pedido pedido) {

        var tipoPessoa = pedido.getDestinatario().getTipoPessoa();
        var valorTotalItens = pedido.getValorTotalItens();
        var regimeTributacao = pedido.getDestinatario().getRegimeTributacao();

        return switch (tipoPessoa) {
            case FISICA -> calculoImpostoPort.calcularSemRegimeDeTributacao(valorTotalItens);
            case JURIDICA -> calcularPorTipoTributacao(valorTotalItens, regimeTributacao);
        };
    }

    public double calcularPorTipoTributacao(double valorTotalItens, RegimeTributacao regimeTributacao) {

        return switch (regimeTributacao) {
            case SIMPLES_NACIONAL -> calculoImpostoPort.calcularSimplesNacional(valorTotalItens);
            case LUCRO_REAL -> calculoImpostoPort.calcularLucroReal(valorTotalItens);
            case LUCRO_PRESUMIDO -> calculoImpostoPort.calcularLucroPresumido(valorTotalItens);
            default -> throw new RegimeTributarioException();
        };
    }
}


