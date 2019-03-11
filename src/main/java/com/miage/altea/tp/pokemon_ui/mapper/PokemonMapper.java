package com.miage.altea.tp.pokemon_ui.mapper;

import com.miage.altea.tp.pokemon_ui.bo.PokemonUI;
import com.miage.altea.tp.pokemon_ui.pokemonsType.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Pokemon;

public class PokemonMapper {
    private static PokemonMapper INSTANCE = new PokemonMapper();

    private PokemonMapper(){
    }

    public static PokemonMapper getInstance(){
        return INSTANCE;
    }

    public PokemonUI pokemonToPokemonUI(Pokemon pokemon, PokemonType pokemonType){
        PokemonUI pokemonUI = new PokemonUI();
        pokemonUI.setId(pokemon.getId());
        pokemonUI.setLevel(pokemon.getLevel());
        pokemonUI.setPokemonType(pokemonType);

        return pokemonUI;
    }
}
