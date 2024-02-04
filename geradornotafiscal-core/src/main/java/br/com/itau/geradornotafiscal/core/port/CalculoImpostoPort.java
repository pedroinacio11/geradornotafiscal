package br.com.itau.geradornotafiscal.core.port;

public interface CalculoImpostoPort {
    double calcularLucroPresumido(double valorTotalItens);

    double calcularLucroReal(double valorTotalItens);

    double calcularSimplesNacional(double valorTotalItens);

    double calcularSemRegimeDeTributacao(double valorTotalItens);
}