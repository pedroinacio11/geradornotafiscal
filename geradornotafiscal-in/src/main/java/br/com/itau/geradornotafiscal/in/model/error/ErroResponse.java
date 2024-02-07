package br.com.itau.geradornotafiscal.in.model.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErroResponse {

    private String code;
    private String message;

    public ErroResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
