package br.com.itau.geradornotafiscal.in.controller;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.model.Pedido;
import br.com.itau.geradornotafiscal.core.usecase.GeradorNotaFiscalServiceUseCase;
import br.com.itau.geradornotafiscal.in.model.NotaFiscalResponse;
import br.com.itau.geradornotafiscal.in.model.PedidoRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedido")
public class GeradorNFController {

    @Autowired
    private GeradorNotaFiscalServiceUseCase geradorNotaFiscalServiceUseCase;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/gerarNotaFiscal")
    public ResponseEntity<NotaFiscalResponse> gerarNotaFiscal(@RequestBody PedidoRequest pedido) {
        // Lógica de processamento do pedido
        // Aqui você pode realizar as operações desejadas com o objeto Pedido

        // Exemplo de retorno
        String mensagem = "Nota fiscal gerada com sucesso para o pedido: " + pedido.getIdPedido();

        Pedido pedidoMapeado = mapper.map(pedido, Pedido.class);
        NotaFiscal notaFiscalGerada = geradorNotaFiscalServiceUseCase.gerarNotaFiscal(pedidoMapeado);
        NotaFiscalResponse notaFiscalResponse = mapper.map(notaFiscalGerada, NotaFiscalResponse.class);

        return new ResponseEntity<>(notaFiscalResponse, HttpStatus.OK);

    }

}
