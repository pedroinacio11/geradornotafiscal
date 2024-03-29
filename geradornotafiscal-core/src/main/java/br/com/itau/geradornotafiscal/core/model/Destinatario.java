package br.com.itau.geradornotafiscal.core.model;

import br.com.itau.geradornotafiscal.core.enums.RegimeTributacao;
import br.com.itau.geradornotafiscal.core.enums.TipoPessoa;
import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Destinatario {

    private String nome;
    private TipoPessoa tipoPessoa;
    private RegimeTributacao regimeTributacao;
    private List<Documento> documentos;
    private List<Endereco> enderecos;

}
