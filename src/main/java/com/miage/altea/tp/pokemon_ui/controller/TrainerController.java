package com.miage.altea.tp.pokemon_ui.controller;

import com.miage.altea.tp.pokemon_ui.bo.PokemonUI;
import com.miage.altea.tp.pokemon_ui.bo.TrainerUI;
import com.miage.altea.tp.pokemon_ui.mapper.PokemonMapper;
import com.miage.altea.tp.pokemon_ui.mapper.TrainerMapper;
import com.miage.altea.tp.pokemon_ui.pokemonsType.bo.PokemonType;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Pokemon;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;
import com.miage.altea.tp.pokemon_ui.pokemonsType.service.PokemonTypeService;
import com.miage.altea.tp.pokemon_ui.trainers.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TrainerController {
    private TrainerService trainerService;
    private PokemonTypeService pokemonTypeService;

    private TrainerMapper traionerMapper = TrainerMapper.getInstance();
    private PokemonMapper pokemonMapper = PokemonMapper.getInstance();

    @GetMapping("/trainers")
    public ModelAndView trainers(){
        List<Trainer> trainers = trainerService.listAllTrainers();
        List<TrainerUI> trainersUI = getTrainersUI(trainers);
        ModelAndView modelAndView = new ModelAndView("trainers");
        modelAndView.getModel().put("trainers", trainersUI);
        return modelAndView;
    }

    @Autowired
    public void setTrainerService(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @Autowired
    public void setPokemonTypeService(PokemonTypeService pokemonTypeService) {
        this.pokemonTypeService = pokemonTypeService;
    }

    private List<TrainerUI> getTrainersUI(List<Trainer> trainers){
        List<TrainerUI> result = new ArrayList<>();
        for(Trainer trainer: trainers) {
            result.add(getTrainerUI(trainer));
        }
        return result;
    }

    private TrainerUI getTrainerUI(Trainer trainer){
        List<Pokemon> pokemons = trainer.getTeam();
        List<PokemonUI> pokemonsUI = getListPokemonUI(pokemons);
        return traionerMapper.trainerToTrainerUI(trainer, pokemonsUI);
    }

    private PokemonUI getPokemonUI(Pokemon pokemon){
        int pokemonId = pokemon.getPokemonType();
        PokemonType pokemonType = pokemonTypeService.getPokemonType(pokemonId);
        PokemonUI pokemonUI = pokemonMapper.pokemonToPokemonUI(pokemon,pokemonType);
        return pokemonUI;
    }

    private List<PokemonUI> getListPokemonUI(List<Pokemon> pokemons){
        List<PokemonUI> pokemonsUI = new ArrayList<>();
        for(Pokemon pokemon : pokemons) {
            pokemonsUI.add(getPokemonUI(pokemon));
        }
        return pokemonsUI;
    }


}
