package br.com.itau.geradornotafiscal.core.model;

import br.com.itau.geradornotafiscal.core.enums.TipoDocumento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Documento {

    private String numero;
    private TipoDocumento tipo;

}
