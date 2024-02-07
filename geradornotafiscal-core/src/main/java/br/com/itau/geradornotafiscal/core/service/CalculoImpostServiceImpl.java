package br.com.itau.geradornotafiscal.core.service;

import br.com.itau.geradornotafiscal.core.port.CalculoImpostoPort;
import org.springframework.stereotype.Service;

import static br.com.itau.geradornotafiscal.core.utils.Constants.*;

@Service
public class CalculoImpostServiceImpl implements CalculoImpostoPort {
    @Override
    public double calcularLucroPresumido(double valorTotalItens) {
        return (valorTotalItens < 1000) ? ALIQUOTA_LUCRO_PRESUMIDO_ATE_1000
                : (valorTotalItens <= 2000) ? ALIQUOTA_LUCRO_PRESUMIDO_ATE_2000
                : (valorTotalItens <= 5000) ? ALIQUOTA_LUCRO_PRESUMIDO_ATE_5000
                : ALIQUOTA_LUCRO_PRESUMIDO_ACIMA_5000;
    }

    @Override
    public double calcularLucroReal(double valorTotalItens) {
        return (valorTotalItens < 1000) ? ALIQUOTA_LUCRO_REAL_ATE_1000
                : (valorTotalItens <= 2000) ? ALIQUOTA_LUCRO_REAL_ATE_2000
                : (valorTotalItens <= 5000) ? ALIQUOTA_LUCRO_REAL_ATE_5000
                : ALIQUOTA_LUCRO_REAL_ACIMA_5000;
    }

    @Override
    public double calcularSimplesNacional(double valorTotalItens) {
        return (valorTotalItens < 1000) ? ALIQUOTA_SIMPLES_NACIONAL_ATE_1000
                : (valorTotalItens <= 2000) ? ALIQUOTA_SIMPLES_NACIONAL_ATE_2000
                : (valorTotalItens <= 5000) ? ALIQUOTA_SIMPLES_NACIONAL_ATE_5000
                : ALIQUOTA_SIMPLES_NACIONAL_ACIMA_5000;
    }

    @Override
    public double calcularSemRegimeDeTributacao(double valorTotalItens) {
        return (valorTotalItens < 500) ? ALIQUOTA_ATE_500
                : (valorTotalItens <= 2000) ? ALIQUOTA_ATE_2000
                : (valorTotalItens <= 3500) ? ALIQUOTA_ATE_3500
                : ALIQUOTA_ACIMA_3500;
    }
}
