package com.example;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import org.springframework.web.util.UriComponentsBuilder;

public class SimpleClient {
    private final RestOperations restOperations;
    private final String baseUrl;

    public SimpleClient(RestOperations restOperations, String baseUrl) {
        this.restOperations = restOperations;
        this.baseUrl = baseUrl;
    }

    public ResponseEntity<java.lang.String> create(
            com.example.Item item
    ) {
        return create$0(
                item
        );
    }

    private ResponseEntity<java.lang.String> create$0(
            com.example.Item bodyArg
    ) {
        Map<String, Object> uriVariables = Collections.emptyMap();
        URI uri = UriComponentsBuilder
                .fromUriString(baseUrl + "/")

                .build(uriVariables);
        RequestEntity<com.example.Item> request = RequestEntity
                .post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .body(bodyArg, com.example.Item.class);
        return restOperations.exchange(request, java.lang.String.class);
    }

    public ResponseEntity<com.example.Item> get(
            java.lang.String id
    ) {
        return get$0(
                id
        );
    }

    private ResponseEntity<com.example.Item> get$0(
            java.lang.String param0
    ) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("id", param0);
        URI uri = UriComponentsBuilder
                .fromUriString(baseUrl + "/{id}")

                .build(uriVariables);
        RequestEntity<java.lang.Void> request = RequestEntity
                .get(uri)
                .build();
        return restOperations.exchange(request, com.example.Item.class);
    }

}
