
package com.pokemon.app_pokemon.model;

import java.util.List;

public class Pokemon {
    private String name;
    private int height;
    private int weight;
    private List<String> types;
    private List<String> abilities;
    private List<Stat> stats;
    private List<String> moves;
    private Sprites sprites;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public List<String> getMoves() {
        return moves;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
    }

    public Sprites getSprites() {
        return sprites;
    }

    public void setSprites(Sprites sprites) {
        this.sprites = sprites;
    }

    // Inner classes for Stats and Sprites
    public static class Stat {
        private String name;
        private int baseStat;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getBaseStat() {
            return baseStat;
        }

        public void setBaseStat(int baseStat) {
            this.baseStat = baseStat;
        }
    }

    public static class Sprites {
        private String frontDefault;
        private String frontShiny;

        public String getFrontDefault() {
            return frontDefault;
        }

        public void setFrontDefault(String frontDefault) {
            this.frontDefault = frontDefault;
        }

        public String getFrontShiny() {
            return frontShiny;
        }

        public void setFrontShiny(String frontShiny) {
            this.frontShiny = frontShiny;
        }
    }
}
