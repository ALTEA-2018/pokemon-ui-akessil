package com.miage.altea.tp.pokemon_ui.mapper;

import com.miage.altea.tp.pokemon_ui.bo.PokemonUI;
import com.miage.altea.tp.pokemon_ui.bo.TrainerUI;
import com.miage.altea.tp.pokemon_ui.trainers.bo.Trainer;

import java.util.List;

public class TrainerMapper {
    private static PokemonMapper pokemonMapper;
    private static TrainerMapper INSTANCE = new TrainerMapper();

    private TrainerMapper(){
        pokemonMapper = PokemonMapper.getInstance();
    }

    public static TrainerMapper getInstance(){
        return INSTANCE;
    }

    public TrainerUI trainerToTrainerUI(Trainer trainer, List<PokemonUI> pokemonsUI){
        TrainerUI trainerUI = new TrainerUI();
        trainerUI.setName(trainer.getName());
        trainerUI.setTeam(pokemonsUI);

        return trainerUI;
    }
}
