package com.miage.altea.tp.pokemon_ui.pokemonsType.service;


import com.miage.altea.tp.pokemon_ui.pokemonsType.bo.PokemonType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {
    RestTemplate restTemplate;

    String pokemonTypeServiceUrl;

    @Cacheable("pokemon-types")
    public List<PokemonType> listPokemonsTypes() {
    
        PokemonType[] result = restTemplate.getForObject(
                this.pokemonTypeServiceUrl, PokemonType[].class );
        return Arrays.asList(result);
    }

    @Cacheable("pokemon-types")
    @Retryable
    public PokemonType getPokemonType(int id){
        PokemonType result = restTemplate.getForObject(
                this.pokemonTypeServiceUrl + "/pokemon-types/{id}", PokemonType.class,id );
        return result;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    @Autowired
    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getPokemonTypeServiceUrl() {
        return pokemonTypeServiceUrl;
    }

    @Value("${pokemonType.service.url}")
    public void setPokemonTypeServiceUrl(String pokemonTypeServiceUrl) {
        this.pokemonTypeServiceUrl = pokemonTypeServiceUrl;
    }
}