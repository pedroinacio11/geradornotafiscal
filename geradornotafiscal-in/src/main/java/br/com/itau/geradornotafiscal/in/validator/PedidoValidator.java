package br.com.itau.geradornotafiscal.in.validator;

import br.com.itau.geradornotafiscal.in.exception.PedidoValidationException;
import br.com.itau.geradornotafiscal.in.model.Item;
import br.com.itau.geradornotafiscal.in.model.PedidoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class PedidoValidator {
    public static void validarPedido(PedidoRequest pedido) {
        double valorTotalItensCalculado = calcularValorTotalItens(pedido.getItens());
        if (Math.abs(pedido.getValorTotalItens() - valorTotalItensCalculado) >= 0.01) {
            throw new PedidoValidationException();
        }
    }

    private static double calcularValorTotalItens(List<Item> itens) {
        double valorTotal = 0.0;
        for (Item item : itens) {
            valorTotal += item.getValorUnitario() * item.getQuantidade();
        }
        return valorTotal;
    }




}