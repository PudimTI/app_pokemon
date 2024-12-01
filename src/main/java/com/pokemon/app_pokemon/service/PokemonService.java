
package com.pokemon.app_pokemon.service;

import com.pokemon.app_pokemon.model.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public PokemonService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public Mono<Pokemon> getPokemon(String name) {
        return webClientBuilder.build()
                .get()
                .uri("https://pokeapi.co/api/v2/pokemon/" + name)
                .retrieve()
                .bodyToMono(PokemonResponse.class)
                .map(this::mapToPokemon);
    }

    private Pokemon mapToPokemon(PokemonResponse response) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(response.getName());
        pokemon.setHeight(response.getHeight());
        pokemon.setWeight(response.getWeight());
        pokemon.setTypes(response.getTypes().stream()
                .map(t -> t.getType().getName())
                .collect(Collectors.toList()));
        pokemon.setAbilities(response.getAbilities().stream()
                .map(a -> a.getAbility().getName())
                .collect(Collectors.toList()));
        pokemon.setStats(response.getStats().stream()
                .map(s -> {
                    Pokemon.Stat stat = new Pokemon.Stat();
                    stat.setName(s.getStat().getName());
                    stat.setBaseStat(s.getBaseStat());
                    return stat;
                })
                .collect(Collectors.toList()));
        pokemon.setMoves(response.getMoves().stream()
                .map(m -> m.getMove().getName())
                .collect(Collectors.toList()));
        Pokemon.Sprites sprites = new Pokemon.Sprites();
        sprites.setFrontDefault(response.getSprites().getFrontDefault());
        sprites.setFrontShiny(response.getSprites().getFrontShiny());
        pokemon.setSprites(sprites);
        return pokemon;
    }

    // Inner class to map API response
    private static class PokemonResponse {
        private String name;
        private int height;
        private int weight;
        private List<TypeWrapper> types;
        private List<AbilityWrapper> abilities;
        private List<StatWrapper> stats;
        private List<MoveWrapper> moves;
        private Sprites sprites;

        // Getters and setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getHeight() { return height; }
        public void setHeight(int height) { this.height = height; }
        public int getWeight() { return weight; }
        public void setWeight(int weight) { this.weight = weight; }
        public List<TypeWrapper> getTypes() { return types; }
        public void setTypes(List<TypeWrapper> types) { this.types = types; }
        public List<AbilityWrapper> getAbilities() { return abilities; }
        public void setAbilities(List<AbilityWrapper> abilities) { this.abilities = abilities; }
        public List<StatWrapper> getStats() { return stats; }
        public void setStats(List<StatWrapper> stats) { this.stats = stats; }
        public List<MoveWrapper> getMoves() { return moves; }
        public void setMoves(List<MoveWrapper> moves) { this.moves = moves; }
        public Sprites getSprites() { return sprites; }
        public void setSprites(Sprites sprites) { this.sprites = sprites; }
    }

    private static class TypeWrapper {
        private NamedAPIResource type;
        public NamedAPIResource getType() { return type; }
        public void setType(NamedAPIResource type) { this.type = type; }
    }

    private static class AbilityWrapper {
        private NamedAPIResource ability;
        public NamedAPIResource getAbility() { return ability; }
        public void setAbility(NamedAPIResource ability) { this.ability = ability; }
    }

    private static class StatWrapper {
        private NamedAPIResource stat;
        private int baseStat;
        public NamedAPIResource getStat() { return stat; }
        public void setStat(NamedAPIResource stat) { this.stat = stat; }
        public int getBaseStat() { return baseStat; }
        public void setBaseStat(int baseStat) { this.baseStat = baseStat; }
    }

    private static class MoveWrapper {
        private NamedAPIResource move;
        public NamedAPIResource getMove() { return move; }
        public void setMove(NamedAPIResource move) { this.move = move; }
    }

    private static class NamedAPIResource {
        private String name;
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    private static class Sprites {
        private String frontDefault;
        private String frontShiny;
        public String getFrontDefault() { return frontDefault; }
        public void setFrontDefault(String frontDefault) { this.frontDefault = frontDefault; }
        public String getFrontShiny() { return frontShiny; }
        public void setFrontShiny(String frontShiny) { this.frontShiny = frontShiny; }
    }
}
