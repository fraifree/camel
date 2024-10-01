package com.example.camel.endpoint;

import org.apache.camel.Endpoint;
import org.apache.camel.support.DefaultComponent;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component("customjdbc")
public class PostgresComponent extends DefaultComponent {

    public PostgresComponent() {
        super();
    }

    @Override
    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        PostgresJdbcEndpoint endpoint = new PostgresJdbcEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
