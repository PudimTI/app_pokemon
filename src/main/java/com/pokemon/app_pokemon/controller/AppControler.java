package com.pokemon.app_pokemon.controller;

import com.pokemon.app_pokemon.model.Pokemon;
import com.pokemon.app_pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

@Controller
public class AppControler {

    private final PokemonService pokemonService;

    @Autowired
    public AppControler(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon/{nome}")
    public Mono<String> mostrarPokemon(@PathVariable String nome, Model model) {
        return pokemonService.buscarPokemon(nome)
                .doOnNext(pokemon -> model.addAttribute("pokemon", pokemon))
                .thenReturn("pokemon")
                .onErrorResume(e -> {
                    model.addAttribute("message", "Pokémon não encontrado!"); // Define a mensagem de erro
                    return Mono.just("error"); // Retorna a view de erro

                });
    }
}