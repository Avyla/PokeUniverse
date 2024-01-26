package com.porfolioprojects.APokedex.service;

import com.porfolioprojects.APokedex.api.PokemonAPI;
import com.porfolioprojects.APokedex.entity.pokemon.PokemonEntity;
import com.porfolioprojects.APokedex.mapper.PokemonMapper;
import com.porfolioprojects.APokedex.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final PokemonMapper pokemonMapper;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository, PokemonMapper pokemonMapper) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonMapper = pokemonMapper;
    }

    private PokemonEntity getPokemonApi(String name){
        try{
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<PokemonAPI> responseEntity
                    = restTemplate
                    .getForEntity("https://pokeapi.co/api/v2/pokemon/" + name + "/", PokemonAPI.class);
            if(responseEntity.getBody() != null){
                PokemonAPI pokemonAPI = responseEntity.getBody();
                return pokemonMapper.toPokemonEntity(pokemonAPI);
            }else{
                throw new RuntimeException("La respuesta de la API fue nula");
            }
        }catch (RestClientException e){
            throw  new RuntimeException("Error al llamar a la API");
        }

    }

    public Optional<PokemonEntity> getPokemonByName(String name){

        Optional<PokemonEntity> pokemonEntity = this.pokemonRepository.findByName(name);

        if(pokemonEntity.isPresent()){
            return pokemonEntity;
        }else{
            try{
                PokemonEntity pokemon = this.getPokemonApi(name);
                return Optional.ofNullable(pokemon);
            }catch (HttpClientErrorException.NotFound e){
                return Optional.empty();
            }
        }

    }

    public Optional<PokemonEntity> getPokemonById(Integer id){
        return this.pokemonRepository.findById(id);
    }

    @Transactional
    public void savePokemon(PokemonEntity pokemonEntity){
        this.pokemonRepository.save(pokemonEntity);
    }

}
