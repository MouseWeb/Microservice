package br.com.mouseweb.loja.util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:endpoint.properties")
@Data
public class Endpoint {

    @Value("${fornecedorInfo}")
    private String fornecedorInfo;

}
