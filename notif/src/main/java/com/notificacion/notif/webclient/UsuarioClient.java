package com.notificacion.notif.webclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Map;

@Component
public class UsuarioClient {

    private final WebClient webClient;

    public UsuarioClient(@Value ("${usuario.service.url}") String usuarioServiceUrl) {
        this.webClient = webClientBuilder()
                .baseUrl(usuarioServiceUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Map<String, Object> getUsuarioById(Long id) {
        return webClient.get()
                .uri("/usuarios/{id}", id)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new RuntimeException("Usuario not found")))
                .bodyToMono(Map.class)
                .block();
    }


}
