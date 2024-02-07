package br.com.itau.geradornotafiscal.core.service;

import br.com.itau.geradornotafiscal.core.enums.TipoPessoa;
import br.com.itau.geradornotafiscal.core.model.Destinatario;
import br.com.itau.geradornotafiscal.core.model.Item;
import br.com.itau.geradornotafiscal.core.model.ItemNotaFiscal;
import br.com.itau.geradornotafiscal.core.model.Pedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcularAliquotaProdutoServiceTest {

    private CalcularAliquotaProdutoService service;

    @BeforeEach
    void setUp() {
        this.service = new CalcularAliquotaProdutoService();
    }


    @Test
    void calcularAliquotaProdutoDeveCalcualarTributoCorretamente() {

        // Itens
        Item item1 = new Item("1", "Item 1", 100.0, 2);
        Item item2 = new Item("2", "Item 2", 150.0, 3);
        List<Item> items = Arrays.asList(item1, item2);

        Pedido pedido = new Pedido();
        Destinatario destinatario = new Destinatario();
        destinatario.setTipoPessoa(TipoPessoa.FISICA);
        pedido.setDestinatario(destinatario);
        pedido.setValorTotalItens(100.0); // valor total dos itens do pedido
        pedido.setItens(items);

        // Calcula percentual da aliquota
        double aliquotaPercentual = 0.05; // 5%

        // Resultados esperados
        double tributoEsperado1 = 100.0 * 0.05; // 5.0
        double tributoEsperado2 = 150.0 * 0.05; // 7.5

        // Executando o método a ser testado
        List<ItemNotaFiscal> result = service.calcularAliquotaProduto(pedido, aliquotaPercentual);

        // Verifica os resultados
        assertEquals(2, result.size());

        // item 1
        assertEquals(item1.getIdItem(), result.get(0).getIdItem());
        assertEquals(item1.getDescricao(), result.get(0).getDescricao());
        assertEquals(item1.getValorUnitario(), result.get(0).getValorUnitario());
        assertEquals(item1.getQuantidade(), result.get(0).getQuantidade());
        assertEquals(tributoEsperado1, result.get(0).getValorTributoItem());

        // item 2
        assertEquals(item2.getIdItem(), result.get(1).getIdItem());
        assertEquals(item2.getDescricao(), result.get(1).getDescricao());
        assertEquals(item2.getValorUnitario(), result.get(1).getValorUnitario());
        assertEquals(item2.getQuantidade(), result.get(1).getQuantidade());
        assertEquals(tributoEsperado2, result.get(1).getValorTributoItem());
    }
}