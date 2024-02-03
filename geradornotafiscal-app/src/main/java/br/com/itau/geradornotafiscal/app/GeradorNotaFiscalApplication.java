package br.com.itau.geradornotafiscal.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static br.com.itau.geradornotafiscal.core.utils.Constants.PACKAGE;

@SpringBootApplication(scanBasePackages = PACKAGE)
public class GeradorNotaFiscalApplication {

    public static void main(String... args) {

        SpringApplication.run(GeradorNotaFiscalApplication.class, args);
    }

}


