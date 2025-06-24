package com.vent.ventas.webclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import java.util.Map;

@Component
public class ProductoClient {

    private final WebClient webClient;

    public ProductoClient(@Value("${producto.service.url}") String productoServiceUrl) {
        this.webClient = WebClient.builder()
                .baseUrl(productoServiceUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public Map<String, Object> obtenerProductoPorId(Long id) {
        return webClient.get()
                .uri("/productos/{id}", id)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(), 
                          response -> Mono.error(new RuntimeException("Producto not found")))
                .bodyToMono(Map.class)
                .block();
    }

    public Double obtenerPrecioProducto(Long id) {
        return webClient.get()
                .uri("/productos/precio/{id}", id)
                .retrieve()
                .onStatus(status -> status.is4xxClientError(), 
                          response -> Mono.error(new RuntimeException("Precio not found")))
                .bodyToMono(Double.class)
                .block();
    }


}
