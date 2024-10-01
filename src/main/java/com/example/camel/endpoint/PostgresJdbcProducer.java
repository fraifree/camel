package com.example.camel.endpoint;

import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultProducer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class PostgresJdbcProducer extends DefaultProducer {

    private final PostgresJdbcEndpoint endpoint;

    public PostgresJdbcProducer(PostgresJdbcEndpoint endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        String query = exchange.getIn().getBody(String.class);
        try (Connection connection = DriverManager.getConnection(endpoint.getJdbcUrl(),
                endpoint.getUsername(),
                endpoint.getPassword())) {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        }
    }
}
