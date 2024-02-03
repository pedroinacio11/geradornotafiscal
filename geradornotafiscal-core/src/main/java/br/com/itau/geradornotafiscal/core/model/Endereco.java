package br.com.itau.geradornotafiscal.core.model;

import br.com.itau.geradornotafiscal.core.enums.Finalidade;
import br.com.itau.geradornotafiscal.core.enums.Regiao;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private String cep;
    private String logradouro;
    private String numero;
    private String estado;
    private String complemento;
    private Finalidade finalidade;
    private Regiao regiao;
}