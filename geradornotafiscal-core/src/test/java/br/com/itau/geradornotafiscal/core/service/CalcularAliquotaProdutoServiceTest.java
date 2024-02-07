package br.com.itau.geradornotafiscal.core.service;

import br.com.itau.geradornotafiscal.core.enums.TipoPessoa;
import br.com.itau.geradornotafiscal.core.model.Destinatario;
import br.com.itau.geradornotafiscal.core.model.Item;
import br.com.itau.geradornotafiscal.core.model.ItemNotaFiscal;
import br.com.itau.geradornotafiscal.core.model.Pedido;
import br.com.itau.geradornotafiscal.core.utils.NotaFiscalBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalcularAliquotaProdutoServiceTest {

    private CalcularAliquotaProdutoService service;

    @BeforeEach
    void setUp() {
        this.service = new CalcularAliquotaProdutoService();
    }


    @Test
    void calcularAliquotaProdutoDeveCalcualarTributoCorretamente() {

        Item item1 = new Item("1", "Item 1", 100.0, 2);
        Item item2 = new Item("2", "Item 2", 150.0, 3);
        List<Item> items = Arrays.asList(item1, item2);

        Pedido pedido = new Pedido();
        Destinatario destinatario = new Destinatario();
        destinatario.setTipoPessoa(TipoPessoa.FISICA);
        pedido.setDestinatario(destinatario);
        pedido.setValorTotalItens(100.0);
        pedido.setItens(items);

        double aliquotaPercentual = 0.05; // 5%

        double tributoEsperado1 = 100.0 * 0.05; // 5.0
        double tributoEsperado2 = 150.0 * 0.05; // 7.5

        List<ItemNotaFiscal> result = service.calcularAliquotaProduto(pedido, aliquotaPercentual);

        assertEquals(2, result.size());

        assertEquals(item1.getIdItem(), result.get(0).getIdItem());
        assertEquals(item1.getDescricao(), result.get(0).getDescricao());
        assertEquals(item1.getValorUnitario(), result.get(0).getValorUnitario());
        assertEquals(item1.getQuantidade(), result.get(0).getQuantidade());
        assertEquals(tributoEsperado1, result.get(0).getValorTributoItem());

        assertEquals(item2.getIdItem(), result.get(1).getIdItem());
        assertEquals(item2.getDescricao(), result.get(1).getDescricao());
        assertEquals(item2.getValorUnitario(), result.get(1).getValorUnitario());
        assertEquals(item2.getQuantidade(), result.get(1).getQuantidade());
        assertEquals(tributoEsperado2, result.get(1).getValorTributoItem());
    }

    @Test
    void testCalcularAliquotaProduto_ComPedidoSemItens() {

        Pedido pedido = Mockito.mock(Pedido.class);
        when(pedido.getItens()).thenReturn(new ArrayList<>());

        CalcularAliquotaProdutoService service = new CalcularAliquotaProdutoService();
        double aliquotaPercentual = 0.1;

        List<ItemNotaFiscal> itensNotaFiscal = service.calcularAliquotaProduto(pedido, aliquotaPercentual);

        assertEquals(0, itensNotaFiscal.size());
    }

    @Test
    void testCalcularAliquotaProduto_ComPedidoComUmItem() {

        Pedido pedido = Mockito.mock(Pedido.class);
        List<Item> itens = new ArrayList<>();

        Item item = new Item();
        item.setIdItem("1");
        item.setDescricao("Item 1");
        item.setValorUnitario(200.0);
        item.setQuantidade(2);

        itens.add(item);
        when(pedido.getItens()).thenReturn(itens);

        CalcularAliquotaProdutoService service = new CalcularAliquotaProdutoService();
        double aliquotaPercentual = 0.1;

        List<ItemNotaFiscal> itensNotaFiscal = service.calcularAliquotaProduto(pedido, aliquotaPercentual);

        assertEquals(1, itensNotaFiscal.size());

        assertEquals(20.0, itensNotaFiscal.get(0).getValorTributoItem());
    }

    @Test
    void calcularValorTributo_Test() {

        CalcularAliquotaProdutoService calc = new CalcularAliquotaProdutoService();

        Item item = new Item();
        item.setValorUnitario(10.0);

        double aliquotaPercentual = 0.1;

        double valorTributo = calc.calcularValorTributo(item, aliquotaPercentual);

        assertEquals(1.0, valorTributo);
    }

    @Test
    void criarItemNotaFiscal_Test() {

        CalcularAliquotaProdutoService calc = new CalcularAliquotaProdutoService();

        Item item = new Item();
        item.setValorUnitario(10.0);
        item.setDescricao("Item 1");
        item.setIdItem("1");
        item.setQuantidade(2);

        double valorTributo = 5.0;

        ItemNotaFiscal itemNotaFiscal = calc.criarItemNotaFiscal(item, valorTributo);

        assertEquals(item.getIdItem(), itemNotaFiscal.getIdItem());
        assertEquals(item.getDescricao(), itemNotaFiscal.getDescricao());
        assertEquals(item.getValorUnitario(), itemNotaFiscal.getValorUnitario());
        assertEquals(item.getQuantidade(), itemNotaFiscal.getQuantidade());
        assertEquals(valorTributo, itemNotaFiscal.getValorTributoItem());
    }
}







