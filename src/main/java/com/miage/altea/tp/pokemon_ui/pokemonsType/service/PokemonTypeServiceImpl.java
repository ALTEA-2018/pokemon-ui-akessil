package com.miage.altea.tp.pokemon_ui.pokemonsType.service;


import com.miage.altea.tp.pokemon_ui.pokemonsType.bo.PokemonType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

//TODO
public class PokemonTypeServiceImpl implements PokemonTypeService {
    RestTemplate restTemplate;
    String pokemonServiceUrl;
    public List<PokemonType> listPokemonsTypes() {

        PokemonType[] result = restTemplate.getForObject(
                this.pokemonServiceUrl, PokemonType[].class );
        return Arrays.asList(result);

    }

    void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        this.pokemonServiceUrl = pokemonServiceUrl;
    }
}