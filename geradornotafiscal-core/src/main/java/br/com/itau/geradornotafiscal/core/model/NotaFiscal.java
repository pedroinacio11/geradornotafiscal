package br.com.itau.geradornotafiscal.core.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class NotaFiscal {

    private String idNotaFiscal;
    private LocalDateTime data;
    private double valorTotalItens;
    private double valorFrete;
    private List<ItemNotaFiscal> itens;
    private Destinatario destinatario;

}