package br.com.itau.geradornotafiscal.core.service;

import br.com.itau.geradornotafiscal.core.enums.RegimeTributacao;
import br.com.itau.geradornotafiscal.core.enums.TipoPessoa;
import br.com.itau.geradornotafiscal.core.port.CalculoImpostoPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CalcularAliquotaTipoPessoaServiceTest {

    @Mock
    private CalculoImpostoPort calculoImpostoPort;

    @InjectMocks
    private CalcularAliquotaTipoPessoaService calcularAliquotaTipoPessoaService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obterAliquotaDeveRetornarAliquotaParaTipoPessoaFisica() {

        double valorTotalItens = 2000.0;
        double aliquotaEsperada = 0.05;

        when(calculoImpostoPort.calcularSemRegimeDeTributacao(valorTotalItens)).thenReturn(aliquotaEsperada);

        double aliquotaObtida = calcularAliquotaTipoPessoaService.obterAliquota(TipoPessoa.FISICA, valorTotalItens, RegimeTributacao.OUTROS);

        assertEquals(aliquotaEsperada, aliquotaObtida);
    }

    @Test
    void obterAliquotaDeveRetornarAliquotaParaTipoPessoaJuridica() {

        double valorTotalItens = 5000.0;
        double aliquotaEsperada = 0.1;

        when(calculoImpostoPort.calcularSimplesNacional(valorTotalItens)).thenReturn(aliquotaEsperada);

        double aliquotaObtida = calcularAliquotaTipoPessoaService.obterAliquota(TipoPessoa.JURIDICA, valorTotalItens, RegimeTributacao.SIMPLES_NACIONAL);

        assertEquals(aliquotaEsperada, aliquotaObtida);
    }

    @Test
    void calcularPorTipoTributacaoSimplesNacional() {

        double valorTotalItens = 1000.0;
        double valorEsperado = 280.0;

        RegimeTributacao regimeTributacao = RegimeTributacao.SIMPLES_NACIONAL;

        when(calculoImpostoPort.calcularSimplesNacional(valorTotalItens)).thenReturn(valorEsperado);

        double result = calcularAliquotaTipoPessoaService.calcularPorTipoTributacao(valorTotalItens, regimeTributacao);

        assertEquals(valorEsperado, result);
    }
    @Test
    void calcularPorTipoTributacaoLucroPresumido() {

        double valorTotalItens = 5000.0;
        double valorEsperado = 25.0;

        RegimeTributacao regimeTributacao = RegimeTributacao.LUCRO_PRESUMIDO;

        when(calculoImpostoPort.calcularLucroPresumido(valorTotalItens)).thenReturn(valorEsperado);

        double result = calcularAliquotaTipoPessoaService.calcularPorTipoTributacao(valorTotalItens, regimeTributacao);

        assertEquals(valorEsperado, result);
    }
    @Test
    void calcularPorTipoTributacaoReal() {

        double valorTotalItens = 750.0;
        double valorEsperado = 20.0;

        RegimeTributacao regimeTributacao = RegimeTributacao.LUCRO_REAL;

        when(calculoImpostoPort.calcularLucroReal(valorTotalItens)).thenReturn(valorEsperado);

        double result = calcularAliquotaTipoPessoaService.calcularPorTipoTributacao(valorTotalItens, regimeTributacao);

        assertEquals(valorEsperado, result);
    }


    @Test
    void calcularPorTipoSemRegimeTributacao() {

        double valorTotalItens = 100.0;
        double valorEsperado = 0;

        when(calculoImpostoPort.calcularSemRegimeDeTributacao(valorTotalItens)).thenReturn(valorEsperado);

        double result = calculoImpostoPort.calcularSemRegimeDeTributacao(valorTotalItens);

        assertEquals(valorEsperado, result);
    }


}