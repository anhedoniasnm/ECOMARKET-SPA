package com.peds.pedido.webclient;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import java.util.Map;

@Component
public class UsuarioClient {


    private final WebClient webcliente;

    


    public UsuarioClient(@Value("${usuario-service.url}") String usuarioServiceUrl){
        this.webcliente= WebClient.builder().baseUrl(usuarioServiceUrl).build();

    }

    public Map<String, Object> getUsuarioById(Long id) {
    return this.webcliente.get()
            .uri("/{id}", id)  // Aquí se reemplaza {id} con el valor
            .retrieve()
            .onStatus(status -> status.is4xxClientError(),
                      response -> response.bodyToMono(String.class)
                              .map(body -> new RuntimeException("Usuario invalido ")))
            .bodyToMono(Map.class)
            .block();  
}


    

}
