package br.com.itau.geradornotafiscal.core.service;

import br.com.itau.geradornotafiscal.core.enums.RegimeTributacaoPJ;
import br.com.itau.geradornotafiscal.core.enums.TipoPessoa;
import org.springframework.stereotype.Service;

import static br.com.itau.geradornotafiscal.core.utils.Constants.*;

@Service
public class CalcularAliquotaTipoPessoaService {

    public double obterAliquota(TipoPessoa tipoPessoa, double valorTotalItens, RegimeTributacaoPJ regimeTributacao) {
        switch (tipoPessoa) {
            case FISICA:
                return pessoaFisica(valorTotalItens);
            case JURIDICA:
                return pessoaJuridica(valorTotalItens, regimeTributacao);
            default:
                throw new IllegalArgumentException("Tipo de pessoa não suportado: " + tipoPessoa);
        }
    }

    private double pessoaFisica(double valorTotalItens) {

        if (valorTotalItens < 500) {
            return ALIQUOTA_ATE_500;
        } else if (valorTotalItens <= 2000) {
            return ALIQUOTA_ATE_2000;
        } else if (valorTotalItens <= 3500) {
            return ALIQUOTA_ATE_3500;
        } else {
            return ALIQUOTA_ACIMA_3500;
        }
    }

    private double pessoaJuridica(double valorTotalItens, RegimeTributacaoPJ regimeTributacao) {

        return switch (regimeTributacao) {
            case SIMPLES_NACIONAL -> calcularAliquotaSimplesNacional(valorTotalItens);
            case LUCRO_REAL -> calcularAliquotaLucroReal(valorTotalItens);
            case LUCRO_PRESUMIDO -> calcularAliquotaLucroPresumido(valorTotalItens);
            default -> throw new IllegalArgumentException("Regime tributário não suportado: " + regimeTributacao);
        };
    }

    private double calcularAliquotaSimplesNacional(double valorTotalItens) {
        return (valorTotalItens < 1000) ? ALIQUOTA_SIMPLES_NACIONAL_ATE_1000
                : (valorTotalItens <= 2000) ? ALIQUOTA_SIMPLES_NACIONAL_ATE_2000
                : (valorTotalItens <= 5000) ? ALIQUOTA_SIMPLES_NACIONAL_ATE_5000
                : ALIQUOTA_SIMPLES_NACIONAL_ACIMA_5000;
    }

    private double calcularAliquotaLucroReal(double valorTotalItens) {
        return (valorTotalItens < 1000) ? ALIQUOTA_LUCRO_REAL_ATE_1000
                : (valorTotalItens <= 2000) ? ALIQUOTA_LUCRO_REAL_ATE_2000
                : (valorTotalItens <= 5000) ? ALIQUOTA_LUCRO_REAL_ATE_5000
                : ALIQUOTA_LUCRO_REAL_ACIMA_5000;
    }

    private double calcularAliquotaLucroPresumido(double valorTotalItens) {
        return (valorTotalItens < 1000) ? ALIQUOTA_LUCRO_PRESUMIDO_ATE_1000
                : (valorTotalItens <= 2000) ? ALIQUOTA_LUCRO_PRESUMIDO_ATE_2000
                : (valorTotalItens <= 5000) ? ALIQUOTA_LUCRO_PRESUMIDO_ATE_5000
                : ALIQUOTA_LUCRO_PRESUMIDO_ACIMA_5000;
    }
}


