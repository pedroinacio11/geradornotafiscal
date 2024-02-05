package br.com.itau.geradornotafiscal.in.model.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErroResponse {

    @JsonProperty("mensagem")
    private String mensagem;

    @JsonProperty("log_code")
    private String logCode;

    public ErroResponse(String mensagem, String logCode) {
        this.mensagem = mensagem;
        this.logCode = logCode;
    }

}
