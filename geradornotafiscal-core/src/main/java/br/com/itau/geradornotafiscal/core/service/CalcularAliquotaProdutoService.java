package br.com.itau.geradornotafiscal.core.service;

import br.com.itau.geradornotafiscal.core.model.Item;
import br.com.itau.geradornotafiscal.core.model.ItemNotaFiscal;
import br.com.itau.geradornotafiscal.core.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalcularAliquotaProdutoService {

    public List<ItemNotaFiscal> calcularAliquotaProduto(Pedido pedido, double aliquotaPercentual) {

        return pedido.getItens().stream()
                .map(item -> criarItemNotaFiscal(item, calcularValorTributo(item, aliquotaPercentual)))
                .collect(Collectors.toList());
    }

    private double calcularValorTributo(Item item, double aliquotaPercentual) {
        return item.getValorUnitario() * aliquotaPercentual;
    }

    private ItemNotaFiscal criarItemNotaFiscal(Item item, double valorTributo) {
        return new ItemNotaFiscal(
                item.getIdItem(),
                item.getDescricao(),
                item.getValorUnitario(),
                item.getQuantidade(),
                valorTributo
        );
    }
}



