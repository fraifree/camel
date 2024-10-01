package com.example.camel.endpoint;

import lombok.Getter;
import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.support.DefaultEndpoint;

@Getter
@UriEndpoint(scheme = "postgres", title = "Postgres", syntax = "postgres:dataSource", producerOnly = true)
public class PostgresJdbcEndpoint extends DefaultEndpoint {

    @UriParam
    private final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";

    @UriParam
    private final String username = "user";

    @UriParam
    private final String password = "password";

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
