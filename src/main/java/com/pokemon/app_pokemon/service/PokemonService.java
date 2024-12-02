package com.pokemon.app_pokemon.service;

import com.pokemon.app_pokemon.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PokemonService {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public PokemonService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<Pokemon> buscarPokemon(String nome) {
        return webClientBuilder.baseUrl("https://pokeapi.co/api/v2/pokemon/")
                .build()
                .get()
                .uri(nome)
                .retrieve()
                .bodyToMono(Pokemon.class);
    }
}
