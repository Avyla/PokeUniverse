package com.porfolioprojects.APokedex.controller;

import com.porfolioprojects.APokedex.api.PokemonAPI;
import com.porfolioprojects.APokedex.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    //HAY 1025 pokemons
    @GetMapping("/search/{pokemonName}")
    public ResponseEntity<?> getPokemonByName(@PathVariable("pokemonName") String pokemonName){
        return ResponseEntity.ok(this.pokemonService.getPokemonByName(pokemonName));
    }

}
