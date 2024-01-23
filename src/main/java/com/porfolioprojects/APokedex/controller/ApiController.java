package com.porfolioprojects.APokedex.controller;

import com.porfolioprojects.APokedex.api.PokemonAPI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping()
public class ApiController {

    //HAY 1025 pokemons
    @GetMapping("/prueba/{pokemonName}")
    public ResponseEntity<PokemonAPI> prueba(@PathVariable("pokemonName") String pokemonName){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PokemonAPI>
                response =
                restTemplate
                        .getForEntity(String.format("https://pokeapi.co/api/v2/pokemon/%s/", pokemonName), PokemonAPI.class);
        return ResponseEntity.ok(response.getBody());
    }

}
