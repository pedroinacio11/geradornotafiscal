package br.com.itau.geradornotafiscal.core.service;

import br.com.itau.geradornotafiscal.core.enums.RegimeTributacaoPJ;
import br.com.itau.geradornotafiscal.core.enums.TipoPessoa;

import br.com.itau.geradornotafiscal.core.port.CalculoImpostoPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalcularAliquotaTipoPessoaService {


    @Autowired
    private CalculoImpostoPort calculoImpostoPort;

    public double obterAliquota(TipoPessoa tipoPessoa, double valorTotalItens, RegimeTributacaoPJ regimeTributacao) {

        return switch (tipoPessoa) {
            case FISICA -> calculoImpostoPort.calcularSemRegimeDeTributacao(valorTotalItens);
            case JURIDICA -> calcularPorTipoTributacao(valorTotalItens, regimeTributacao);
        };
    }

    private double calcularPorTipoTributacao(double valorTotalItens, RegimeTributacaoPJ regimeTributacao) {

        return switch (regimeTributacao) {
            case SIMPLES_NACIONAL -> calculoImpostoPort.calcularSimplesNacional(valorTotalItens);
            case LUCRO_REAL -> calculoImpostoPort.calcularLucroReal(valorTotalItens);
            case LUCRO_PRESUMIDO -> calculoImpostoPort.calcularLucroPresumido(valorTotalItens);
            default -> throw new IllegalArgumentException("Regime tributário não suportado: " + regimeTributacao);
        };
    }
}


