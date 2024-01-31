package com.porfolioprojects.APokedex.controller;

import com.porfolioprojects.APokedex.dto.pokemon.PokemonDTO;
import com.porfolioprojects.APokedex.dto.projection.PokemonProjection;
import com.porfolioprojects.APokedex.service.PokemonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    //HAY 1025 pokemons
    @GetMapping("/search/{pokemonName}")
    public ResponseEntity<PokemonDTO> getPokemonByName(@PathVariable("pokemonName") String identifier){

        PokemonDTO pokemonDTO = this.pokemonService.getPokemon(identifier);

        if(pokemonDTO == null){
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pokemonDTO);


    }

    @GetMapping("/home")
    public ResponseEntity<Set<PokemonProjection>> getRandomPokemons(){

        return this.pokemonService.getHome()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping("/type/{typeName}")
    public ResponseEntity<Set<PokemonProjection>> getRandomPokemonsByType(@PathVariable("typeName")String typeName){

        return this.pokemonService.getHomeByType(typeName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

}
