package br.com.itau.geradornotafiscal.in.validator;

import br.com.itau.geradornotafiscal.core.exception.PedidoValidationException;
import br.com.itau.geradornotafiscal.in.model.pedido.Item;
import br.com.itau.geradornotafiscal.in.model.pedido.PedidoRequest;

import java.util.List;

public class PedidoValidator {
    public static PedidoRequest validarPedido(PedidoRequest pedido) {
        double valorTotalItensCalculado = calcularValorTotalItens(pedido.getItens());
        if (Math.abs(pedido.getValorTotalItens() - valorTotalItensCalculado) >= 0.01) {
            throw new PedidoValidationException();
        }

        return pedido;
    }

    private static double calcularValorTotalItens(List<Item> itens) {
        double valorTotal = 0.0;
        for (Item item : itens) {
            valorTotal += item.getValorUnitario() * item.getQuantidade();
        }
        return valorTotal;
    }

}