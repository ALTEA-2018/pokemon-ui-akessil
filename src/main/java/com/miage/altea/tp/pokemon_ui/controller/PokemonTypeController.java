package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.pokemonsType.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.pokemonsType.service.PokemonTypeService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Controller
@SpringBootApplication
public class PokemonTypeController {

    private PokemonTypeService pokemonTypeservice;

    @GetMapping("/")
    public ModelAndView pokedex(){
        List<PokemonType> pokemons = service.listPokemonsTypes();
        ModelAndView model = new ModelAndView("pokedex");
        model.getModel().put("pokemonTypes", pokemons);
        return model;
    }

    public PokemonTypeService getPokemonTypeservice() {
        return pokemonTypeservice;
    }

    public void setPokemonTypeservice(PokemonTypeService pokemonTypeservice) {
        this.pokemonTypeservice = pokemonTypeservice;
    }
}
