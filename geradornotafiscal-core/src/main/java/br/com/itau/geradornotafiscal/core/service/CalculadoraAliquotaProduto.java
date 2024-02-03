package br.com.itau.geradornotafiscal.core.service;

import br.com.itau.geradornotafiscal.core.model.Item;
import br.com.itau.geradornotafiscal.core.model.ItemNotaFiscal;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraAliquotaProduto {
    private static List<ItemNotaFiscal> itemNotaFiscalList = new ArrayList<>();

    public List<ItemNotaFiscal> calcularAliquota(List<Item> items, double aliquotaPercentual) {

        for (Item item : items) {
            double valorTributo = item.getValorUnitario() * aliquotaPercentual;
            ItemNotaFiscal itemNotaFiscal = ItemNotaFiscal.builder()
                    .idItem(item.getIdItem())
                    .descricao(item.getDescricao())
                    .valorUnitario(item.getValorUnitario())
                    .quantidade(item.getQuantidade())
                    .valorTributoItem(valorTributo)
                    .build();
            itemNotaFiscalList.add(itemNotaFiscal);
        }
        return itemNotaFiscalList;
    }
}



