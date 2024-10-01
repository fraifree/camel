package com.example.camel.config;

import com.example.camel.endpoint.PostgresComponent;
import org.apache.camel.CamelContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CamelConfig {

    @Bean
    public PostgresComponent myCustomComponent(CamelContext camelContext) {
        PostgresComponent postgresComponent = new PostgresComponent();
        camelContext.addComponent("postgres", postgresComponent);
        return postgresComponent;
    }
}
