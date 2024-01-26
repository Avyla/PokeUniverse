package com.porfolioprojects.APokedex.controller;

import com.porfolioprojects.APokedex.api.PokemonAPI;
import com.porfolioprojects.APokedex.entity.pokemon.PokemonEntity;
import com.porfolioprojects.APokedex.mapper.PokemonMapper;
import com.porfolioprojects.APokedex.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;
    private final PokemonMapper pokemonMapper;

    public PokemonController(PokemonService pokemonService, PokemonMapper pokemonMapper) {
        this.pokemonService = pokemonService;
        this.pokemonMapper = pokemonMapper;
    }

    //HAY 1025 pokemons
    @GetMapping("/search/{pokemonName}")
    public ResponseEntity<?> getPokemonByName(@PathVariable("pokemonName") String pokemonName){

        PokemonEntity pokemonEntity = this.pokemonService.getPokemonByName(pokemonName);

        if (pokemonEntity == null){
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }else {
            return ResponseEntity.ok(pokemonEntity);
        }

    }

}
