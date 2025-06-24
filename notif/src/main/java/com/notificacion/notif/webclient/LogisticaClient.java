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
public class LogisticaClient {

    private final WebClient webClient;

    public LogisticaClient(@Value("${logistica.service.url}") String logisticaServiceUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(logisticaServiceUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Map<String, Object> getLogisticaById(Long id) {
        return webClient.get()
                .uri("/logisticas/{id}", id)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new RuntimeException("Logistica not found")))
                .bodyToMono(Map.class)
                .block();
    }

}
