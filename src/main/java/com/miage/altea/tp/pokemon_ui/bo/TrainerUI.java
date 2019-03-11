package com.miage.altea.tp.pokemon_ui.bo;

import java.util.List;

public class TrainerUI {

    private String name;
    private List<PokemonUI> team;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PokemonUI> getTeam() {
        return team;
    }

    public void setTeam(List<PokemonUI> team) {
        this.team = team;
    }
}
