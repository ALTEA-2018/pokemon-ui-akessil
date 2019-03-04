package com.miage.altea.tp.pokemon_ui.pokemonsType.service;


import com.miage.altea.tp.pokemon_ui.pokemonsType.bo.PokemonType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

//TODO
public class PokemonTypeServiceImpl implements PokemonTypeService {
    RestTemplate restTemplate;
    String pokemonTypeServiceUrl;
    public List<PokemonType> listPokemonsTypes() {

        PokemonType[] result = restTemplate.getForObject(
                this.pokemonTypeServiceUrl, PokemonType[].class );
        return Arrays.asList(result);
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getPokemonTypeServiceUrl() {
        return pokemonTypeServiceUrl;
    }

    public void setPokemonTypeServiceUrl(String pokemonTypeServiceUrl) {
        this.pokemonTypeServiceUrl = pokemonTypeServiceUrl;
    }
}