package br.com.itau.geradornotafiscal.core.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstantsTest {
    @Test
    void testConstantsValues() {
        assertEquals("br.com.itau", Constants.PACKAGE);
        assertEquals(0, Constants.ALIQUOTA_ATE_500);
        assertEquals(0.12, Constants.ALIQUOTA_ATE_2000);
        assertEquals(0.15, Constants.ALIQUOTA_ATE_3500);
        assertEquals(0.17, Constants.ALIQUOTA_ACIMA_3500);
        assertEquals(0.03, Constants.ALIQUOTA_SIMPLES_NACIONAL_ATE_1000);
        assertEquals(0.07, Constants.ALIQUOTA_SIMPLES_NACIONAL_ATE_2000);
        assertEquals(0.13, Constants.ALIQUOTA_SIMPLES_NACIONAL_ATE_5000);
        assertEquals(0.19, Constants.ALIQUOTA_SIMPLES_NACIONAL_ACIMA_5000);
        assertEquals(0.03, Constants.ALIQUOTA_LUCRO_REAL_ATE_1000);
        assertEquals(0.09, Constants.ALIQUOTA_LUCRO_REAL_ATE_2000);
        assertEquals(0.15, Constants.ALIQUOTA_LUCRO_REAL_ATE_5000);
        assertEquals(0.20, Constants.ALIQUOTA_LUCRO_REAL_ACIMA_5000);
        assertEquals(0.03, Constants.ALIQUOTA_LUCRO_PRESUMIDO_ATE_1000);
        assertEquals(0.09, Constants.ALIQUOTA_LUCRO_PRESUMIDO_ATE_2000);
        assertEquals(0.16, Constants.ALIQUOTA_LUCRO_PRESUMIDO_ATE_5000);
        assertEquals(0.20, Constants.ALIQUOTA_LUCRO_PRESUMIDO_ACIMA_5000);
        assertEquals("O valor total item é inválido.", Constants.VALOR_SOMA_ITENS_INVALIDO);
        assertEquals("PED_OO1", Constants.PED_CODE);
        assertEquals("Documento inválido", Constants.DOCUMENTO_INVALIDO);
        assertEquals("CPF_CNPJ_001", Constants.CPF_CNPJ_CODE);
        assertEquals("Regimo tributário inválido", Constants.REGIME_TRIBUBTARIO_INVALIDO);
        assertEquals("REG_001", Constants.REG_CODE);
    }
}