package com.example.camel.endpoint;

import lombok.Getter;
import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.DefaultEndpoint;
import org.springframework.beans.factory.annotation.Value;

@Getter
@UriEndpoint(scheme = "jdbc", title = "Postgres", syntax = "jdbc:dataSource", producerOnly = true)
public class PostgresJdbcEndpoint extends DefaultEndpoint {

    @UriParam
    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @UriParam
    @Value("${spring.datasource.username}")
    private String username;

    @UriParam
    @Value("${spring.datasource.password}")
    private String password;

    public PostgresJdbcEndpoint(String uri, PostgresComponent component) {
        super(uri, component);
    }

    @Override
    public PostgresJdbcProducer createProducer() {
        return new PostgresJdbcProducer(this);
    }

    @Override
    public Consumer createConsumer(Processor processor) {
        return null;
    }
}
