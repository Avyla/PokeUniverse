package com.porfolioprojects.APokedex.controller;

import com.porfolioprojects.APokedex.entity.pokemon.PokemonEntity;
import com.porfolioprojects.APokedex.mapper.PokemonMapper;
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
    public ResponseEntity<?> getPokemon(@PathVariable("pokemonName") String pokemonName){

        PokemonEntity pokemonEntity = this.pokemonService.getPokemon(pokemonName);

        if (pokemonEntity == null){
            return (ResponseEntity<?>) ResponseEntity.notFound();
        }else {
            return ResponseEntity.ok(pokemonEntity);
        }

    }

    @GetMapping("/home")
    public ResponseEntity<Set<PokemonEntity>> getRandomPokemons(){
        return ResponseEntity.ok(this.pokemonService.getHome());
    }

}
