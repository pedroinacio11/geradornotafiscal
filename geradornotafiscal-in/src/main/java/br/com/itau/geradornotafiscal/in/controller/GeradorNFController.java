package br.com.itau.geradornotafiscal.in.controller;

import br.com.itau.geradornotafiscal.core.model.NotaFiscal;
import br.com.itau.geradornotafiscal.core.model.Pedido;
import br.com.itau.geradornotafiscal.core.usecase.GeradorNotaFiscalServiceUseCase;
import br.com.itau.geradornotafiscal.in.model.pedido.NotaFiscalResponse;
import br.com.itau.geradornotafiscal.in.model.pedido.PedidoRequest;
import br.com.itau.geradornotafiscal.in.validator.PedidoValidator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/pedido")
public class GeradorNFController {

    @Autowired
    private GeradorNotaFiscalServiceUseCase geradorNotaFiscalServiceUseCase;

    @Autowired
    private ModelMapper mapper;

    @PostMapping("/gerarNotaFiscal")
    public ResponseEntity<NotaFiscalResponse> gerarNotaFiscal(@Valid @RequestBody PedidoRequest pedido) {

        Pedido pedidoMapeado = mapper.map(PedidoValidator.validarPedido(pedido), Pedido.class);
        NotaFiscal notaFiscalGerada = geradorNotaFiscalServiceUseCase.gerarNotaFiscal(pedidoMapeado);
        NotaFiscalResponse notaFiscalResponse = mapper.map(notaFiscalGerada, NotaFiscalResponse.class);

        log.info("Nota fiscal gerada com sucesso {} ", notaFiscalResponse);

        return new ResponseEntity<>(notaFiscalResponse, HttpStatus.OK);

    }

}
