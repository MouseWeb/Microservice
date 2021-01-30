package br.com.mouseweb.loja.util;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:endpoint.properties")
@Data
public class Endpoint {

    private String fornecedorInfo;
}
