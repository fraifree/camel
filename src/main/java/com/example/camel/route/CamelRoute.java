package com.example.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CamelRoute extends RouteBuilder {
    @Override
    public void configure() {
        from("direct:saveToPostgres")
                .log("Executing SQL query: ${body}")
                .doTry()
                .to("postgres:dataSource")
                .log("Query execution completed")
                .doCatch(Exception.class)
                .log("Error executing query: ${exception.message}")
                .end();
    }
}
