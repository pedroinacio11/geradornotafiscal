package br.com.itau.geradornotafiscal.in.model.error;

import lombok.Data;

@Data
public class ErroResponse {

    private String message;
    private String code;

    public ErroResponse(String message, String code) {
        this.message = message;
        this.code = code;
    }

}
