package br.com.itau.geradornotafiscal.core.utils;

import br.com.itau.geradornotafiscal.core.enums.RegimeTributacaoPJ;

public class ObterAliquota {

    private static final double ALIQUOTA_ATE_500 = 0;
    private static final double ALIQUOTA_ATE_2000 = 0.12;
    private static final double ALIQUOTA_ATE_3500 = 0.15;
    private static final double ALIQUOTA_ACIMA_3500 = 0.17;
    private static final double ALIQUOTA_SIMPLES_NACIONAL_ATE_1000 = 0.03;
    private static final double ALIQUOTA_SIMPLES_NACIONAL_ATE_2000 = 0.07;
    private static final double ALIQUOTA_SIMPLES_NACIONAL_ATE_5000 = 0.13;
    private static final double ALIQUOTA_SIMPLES_NACIONAL_ACIMA_5000 = 0.19;
    private static final double ALIQUOTA_LUCRO_REAL_ATE_1000 = 0.03;
    private static final double ALIQUOTA_LUCRO_REAL_ATE_2000 = 0.09;
    private static final double ALIQUOTA_LUCRO_REAL_ATE_5000 = 0.15;
    private static final double ALIQUOTA_LUCRO_REAL_ACIMA_5000 = 0.20;
    private static final double ALIQUOTA_LUCRO_PRESUMIDO_ATE_1000 = 0.03;
    private static final double ALIQUOTA_LUCRO_PRESUMIDO_ATE_2000 = 0.09;
    private static final double ALIQUOTA_LUCRO_PRESUMIDO_ATE_5000 = 0.16;
    private static final double ALIQUOTA_LUCRO_PRESUMIDO_ACIMA_5000 = 0.20;



    public double pessoaFisica(double valorTotalItens) {

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

    public double pessoaJuridica(double valorTotalItens, RegimeTributacaoPJ regimeTributacao) {

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


