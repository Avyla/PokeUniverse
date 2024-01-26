package com.porfolioprojects.APokedex.service;

import com.porfolioprojects.APokedex.api.PokemonAPI;
import com.porfolioprojects.APokedex.entity.pokemon.*;
import com.porfolioprojects.APokedex.mapper.PokemonMapper;
import com.porfolioprojects.APokedex.repository.*;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private final PokemonRepository pokemonRepository;
    private final StatRepository statRepository;
    private final TypeRepository typeRepository;
    private final AbilityRepository abilityRepository;
    private final PokemonMapper pokemonMapper;

    @Autowired
    public PokemonService(PokemonRepository pokemonRepository, StatRepository statRepository, TypeRepository typeRepository, AbilityRepository abilityRepository, PokemonMapper pokemonMapper) {
        this.pokemonRepository = pokemonRepository;
        this.statRepository = statRepository;
        this.typeRepository = typeRepository;
        this.abilityRepository = abilityRepository;
        this.pokemonMapper = pokemonMapper;


    }

    private PokemonEntity getPokemonApi(String name) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<PokemonAPI> responseEntity
                    = restTemplate
                    .getForEntity("https://pokeapi.co/api/v2/pokemon/" + name + "/", PokemonAPI.class);
            if (responseEntity.getBody() != null) {
                PokemonAPI pokemonAPI = responseEntity.getBody();
                return pokemonMapper.toPokemonEntity(pokemonAPI);
            } else {
                throw new RuntimeException("La respuesta de la API fue nula");
            }
        } catch (RestClientException e) {
            throw new RuntimeException("Error al llamar a la API");
        }

    }

    public PokemonEntity getPokemonByName(String name) {

        Optional<PokemonEntity> pokemonEntity = this.pokemonRepository.findByName(name);

        if (pokemonEntity.isPresent()) {
            return pokemonEntity.get();
        } else {
            try {
                PokemonEntity pokemon = this.getPokemonApi(name);
                if (pokemon != null) {
                    this.savePokemon(pokemon);
                }
                return pokemon;
            } catch (HttpClientErrorException.NotFound e) {
                return null;
            }
        }

    }

    public Optional<PokemonEntity> getPokemonById(Integer id) {
        return this.pokemonRepository.findById(id);
    }

    @Transactional
    public void savePokemon(PokemonEntity pokemon) {
        PokemonEntity newPokemon = new PokemonEntity();

        newPokemon.setPokemonId(pokemon.getPokemonId());
        newPokemon.setName(pokemon.getName());
        newPokemon.setBaseExperience(pokemon.getBaseExperience());
        newPokemon.setHeight(pokemon.getHeight());
        newPokemon.setIsDefault(pokemon.getIsDefault());
        newPokemon.setOrder(pokemon.getOrder());
        newPokemon.setWeight(pokemon.getWeight());
        newPokemon.setLocationAreaEncounters(pokemon.getLocationAreaEncounters());
        newPokemon.setSprites(pokemon.getSprites());

        List<StatsEntity> statsList = new ArrayList<>();

        // Guarda las estadísticas y configura la relación bidireccional
        pokemon.getStats().forEach(stats -> {
            StatsEntity newStats = new StatsEntity();

            newStats.setBaseStat(stats.getBaseStat());
            newStats.setEffort(stats.getEffort());

            StatEntity existingStat = this.statRepository.findByName(stats.getStat().getName());

            if (existingStat == null) {
                // Si la estadística no existe, créala y guárdala
                StatEntity newStat = new StatEntity();
                newStat.setName(stats.getStat().getName());
                newStat.setUrl(stats.getStat().getUrl());
                this.statRepository.save(newStat);
                newStats.setStat(newStat);
            } else {
                newStats.setStat(existingStat);
            }

            newStats.setPokemon(newPokemon);
            statsList.add(newStats);
        });

        // Configura la relación bidireccional antes de guardar PokemonEntity
        statsList.forEach(stats -> stats.setPokemon(newPokemon));

        newPokemon.setStats(statsList);

        List<TypesEntity> typesList = new ArrayList<TypesEntity>();

        pokemon.getTypes().forEach(types -> {

            TypesEntity newTypes = new TypesEntity();

            newTypes.setSlot(types.getSlot());

            TypeEntity existingType = this.typeRepository.findByName(types.getType().getName());
            if (existingType == null) {
                TypeEntity newType = new TypeEntity();
                newType.setName(types.getType().getName());
                newType.setUrl(types.getType().getUrl());
                this.typeRepository.save(newType);
                newTypes.setType(newType);
            } else {
                newTypes.setType(existingType);
            }

            newTypes.setPokemon(newPokemon);
            typesList.add(newTypes);
        });

        typesList.forEach(types -> types.setPokemon(newPokemon));
        newPokemon.setTypes(typesList);

        List<AbilitiesEntity> abilitiesList = new ArrayList<AbilitiesEntity>();

        pokemon.getAbilities().forEach(abilities -> {

            AbilitiesEntity newAbilities = new AbilitiesEntity();

            newAbilities.setIsHiden(abilities.getIsHiden());
            newAbilities.setSlot(abilities.getSlot());

            AbilityEntity existingAbility = this.abilityRepository.findByName(abilities.getAbility().getName());
            if (existingAbility == null) {
                AbilityEntity newAbility = new AbilityEntity();
                newAbility.setName(abilities.getAbility().getName());
                newAbility.setUrl(abilities.getAbility().getUrl());
                this.abilityRepository.save(newAbility);
                newAbilities.setAbility(newAbility);
            } else {
                newAbilities.setAbility(existingAbility);
            }
            newAbilities.setPokemon(newPokemon);
            abilitiesList.add(newAbilities);

        });

        abilitiesList.forEach(abilities -> abilities.setPokemon(newPokemon));
        newPokemon.setAbilities(abilitiesList);

        // Guarda PokemonEntity primero
        this.pokemonRepository.save(newPokemon);
    }


}
