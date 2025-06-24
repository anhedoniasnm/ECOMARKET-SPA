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
public class PagoClient {

    private final WebClient webClient;

    public PagoClient(@Value("${pago.service.url}") String pagoServiceUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(pagoServiceUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Map<String, Object> getPagoById(Long id) {
        return webClient.get()
                .uri("/pagos/{id}", id)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new RuntimeException("Pago not found")))
                .bodyToMono(Map.class)
                .block();
    }

}
