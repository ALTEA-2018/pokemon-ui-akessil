package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.pokemonsType.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.pokemonsType.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@SpringBootApplication
public class PokemonTypeController {

    private PokemonTypeService pokemonTypeService;

    @GetMapping("/pokedex")
    public ModelAndView pokedex(){
        List<PokemonType> pokemons = pokemonTypeService.listPokemonsTypes();
        ModelAndView modelAndView = new ModelAndView("pokedex");
        modelAndView.getModel().put("pokemonTypes", pokemons);
        return modelAndView;
    }

    @Autowired
    public void setPokemonTypeService(PokemonTypeService pokemonTypeservice) {
        this.pokemonTypeService = pokemonTypeservice;
    }
}
