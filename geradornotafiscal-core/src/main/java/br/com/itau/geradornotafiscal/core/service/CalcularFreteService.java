package br.com.itau.geradornotafiscal.core.service;

import br.com.itau.geradornotafiscal.core.enums.Finalidade;
import br.com.itau.geradornotafiscal.core.enums.Regiao;
import br.com.itau.geradornotafiscal.core.model.Endereco;
import br.com.itau.geradornotafiscal.core.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class CalcularFreteService {

    private static final Map<Regiao, Double> FRETES_POR_REGIAO = new HashMap<>();

    static {
        FRETES_POR_REGIAO.put(Regiao.NORTE, 1.08);
        FRETES_POR_REGIAO.put(Regiao.NORDESTE, 1.085);
        FRETES_POR_REGIAO.put(Regiao.CENTRO_OESTE, 1.07);
        FRETES_POR_REGIAO.put(Regiao.SUDESTE, 1.048);
        FRETES_POR_REGIAO.put(Regiao.SUL, 1.06);
    }

    public double calcularValorFreteComPercentual(Pedido pedido) {
        double valorFrete = pedido.getValorFrete();
        Regiao regiaoEntrega = calcularRegiaoEntrega(pedido);
        return valorFrete * FRETES_POR_REGIAO.getOrDefault(regiaoEntrega, 0.0);
    }

    private Regiao calcularRegiaoEntrega(Pedido pedido) {
        return pedido.getDestinatario().getEnderecos().stream()
                .filter(this::enderecoDeEntrega)
                .map(Endereco::getRegiao)
                .findFirst()
                .orElse(null);
    }

    private boolean enderecoDeEntrega(Endereco endereco) {
        Set<Finalidade> finalidadeEntrega = EnumSet.of(Finalidade.ENTREGA, Finalidade.COBRANCA_ENTREGA);
        return finalidadeEntrega.contains(endereco.getFinalidade());
    }
}