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
public class PedidoClient {

    private final WebClient webClient;

    public PedidoClient(@Value("${pedido.service.url}") String pedidoServiceUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(pedidoServiceUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Map<String, Object> getPedidoById(Long id) {
        return webClient.get()
                .uri("/pedidos/{id}", id)
                .retrieve()
                .onStatus(HttpStatus::is4xxClientError, response -> Mono.error(new RuntimeException("Pedido not found")))
                .bodyToMono(Map.class)
                .block();
    }


}
