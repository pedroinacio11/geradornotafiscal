package br.com.itau.geradornotafiscal.core.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static br.com.itau.geradornotafiscal.core.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculoImpostServiceTest {

    @InjectMocks
    private CalculoImpostService calculoImpostService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalcularLucroPresumido() {
        assertEquals(ALIQUOTA_LUCRO_PRESUMIDO_ATE_1000, calculoImpostService.calcularLucroPresumido(800));
        assertEquals(ALIQUOTA_LUCRO_PRESUMIDO_ATE_2000, calculoImpostService.calcularLucroPresumido(1500));
        assertEquals(ALIQUOTA_LUCRO_PRESUMIDO_ATE_5000, calculoImpostService.calcularLucroPresumido(4000));
        assertEquals(ALIQUOTA_LUCRO_PRESUMIDO_ACIMA_5000, calculoImpostService.calcularLucroPresumido(6000));

    }

    @Test
    public void testCalcularLucroReal() {
        assertEquals(ALIQUOTA_LUCRO_REAL_ATE_1000, calculoImpostService.calcularLucroReal(800));
        assertEquals(ALIQUOTA_LUCRO_REAL_ATE_2000, calculoImpostService.calcularLucroReal(1500));
        assertEquals(ALIQUOTA_LUCRO_REAL_ATE_5000, calculoImpostService.calcularLucroReal(4000));
        assertEquals(ALIQUOTA_LUCRO_REAL_ACIMA_5000, calculoImpostService.calcularLucroReal(6000));
    }

    @Test
    public void testCalcularSimplesNacional() {
        assertEquals(ALIQUOTA_SIMPLES_NACIONAL_ATE_1000, calculoImpostService.calcularSimplesNacional(800));
        assertEquals(ALIQUOTA_SIMPLES_NACIONAL_ATE_2000, calculoImpostService.calcularSimplesNacional(1500));
        assertEquals(ALIQUOTA_SIMPLES_NACIONAL_ATE_5000, calculoImpostService.calcularSimplesNacional(4000));
        assertEquals(ALIQUOTA_SIMPLES_NACIONAL_ACIMA_5000, calculoImpostService.calcularSimplesNacional(6000));
    }

    @Test
    public void testCalcularSemRegimeDeTributacao() {
        assertEquals(ALIQUOTA_ATE_500, calculoImpostService.calcularSemRegimeDeTributacao(400));
        assertEquals(ALIQUOTA_ATE_2000, calculoImpostService.calcularSemRegimeDeTributacao(1500));
        assertEquals(ALIQUOTA_ATE_3500, calculoImpostService.calcularSemRegimeDeTributacao(3000));
        assertEquals(ALIQUOTA_ACIMA_3500, calculoImpostService.calcularSemRegimeDeTributacao(5000));
    }
}