
package com.pokemon.app_pokemon.controller;

import com.pokemon.app_pokemon.model.Pokemon;
import com.pokemon.app_pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppControler {

    private final PokemonService pokemonService;

    @Autowired
    public AppControler(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/pokemon")
    public String getPokemon(@RequestParam String name, Model model) {
        Pokemon pokemon = pokemonService.getPokemon(name).block(); // Synchronously retrieve data
        model.addAttribute("pokemon", pokemon);
        return "pokemon";
    }
}
