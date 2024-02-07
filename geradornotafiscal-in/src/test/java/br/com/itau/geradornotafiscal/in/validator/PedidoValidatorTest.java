package br.com.itau.geradornotafiscal.in.validator;

import br.com.itau.geradornotafiscal.core.exception.PedidoValidationException;
import br.com.itau.geradornotafiscal.in.model.pedido.Item;
import br.com.itau.geradornotafiscal.in.model.pedido.PedidoRequest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PedidoValidatorTest {

    @Test
    void testValidarPedido_ValidTotal() {

        List<Item> itens = new ArrayList<>();

        Item item1 = new Item();
        item1.setDescricao("Produto 1");
        item1.setValorUnitario(10.0);
        item1.setQuantidade(2);

        Item item2 = new Item();
        item2.setDescricao("Produto 2");
        item2.setValorUnitario(15.0);
        item2.setQuantidade(3);

        itens.add(item1); // Valor total: 20.0
        itens.add(item2); // Valor total: 45.0

        double valorTotalItens = 65.0;

        PedidoRequest pedido = new PedidoRequest();

        pedido.setItens(itens);
        pedido.setValorTotalItens(valorTotalItens);

        PedidoRequest result = PedidoValidator.validarPedido(pedido);

        assertEquals(pedido, result);
    }

    @Test
    void testValidarPedido_InvalidTotal() {

        List<Item> itens = new ArrayList<>();

        Item item1 = new Item();
        item1.setDescricao("Produto 1");
        item1.setValorUnitario(10.0);
        item1.setQuantidade(2);

        Item item2 = new Item();
        item2.setDescricao("Produto 2");
        item2.setValorUnitario(15.0);
        item2.setQuantidade(3);

        itens.add(item1); // Valor total: 20.0
        itens.add(item2); // Valor total: 45.0

        double valorTotalItens = 60.0; // Total fornecido é diferente do total calculado

        PedidoRequest pedido = new PedidoRequest();

        pedido.setItens(itens);
        pedido.setValorTotalItens(valorTotalItens);

        assertThrows(PedidoValidationException.class, () -> {
            PedidoValidator.validarPedido(pedido);
        });
    }
}