package com.pokemonproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration //classe contém métodos de configuração que vão ser executados pelo Spring
public class WebClientConfig {

    @Bean //Usado para definir métodos que produzem objetos gerenciados pelo Spring
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl("https://pokeapi.co/api/v2").build();
    }
}