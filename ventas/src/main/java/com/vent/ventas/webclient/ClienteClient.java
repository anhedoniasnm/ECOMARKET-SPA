package com.vent.ventas.webclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Map;

@Component
public class ClienteClient {

    private final WebClient webClient;

    public ClienteClient(@Value ("${usuario.service.url}") String usuarioServiceUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(usuarioServiceUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Map<String, Object> obtenerClientePorId(Long id) {
        return webClient.get()
                .uri("/usuarios/{id}", id)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(), 
                          response -> Mono.error(new RuntimeException("Cliente not found")))
                .bodyToMono(Map.class)
                .block();
    }


}