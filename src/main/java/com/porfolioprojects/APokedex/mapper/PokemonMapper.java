package com.porfolioprojects.APokedex.mapper;

import com.porfolioprojects.APokedex.api.PokemonAPI;
import com.porfolioprojects.APokedex.entity.pokemon.PokemonEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SpritesMapper.class, StatsMapper.class, TypesMapper.class, AbilitiesMapper.class})
public interface PokemonMapper {

    @Mappings({
            @Mapping(source = "id", target = "pokemonId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "base_experience", target = "baseExperience"),
            @Mapping(source = "height", target = "height"),
            @Mapping(source = "is_default", target = "isDefault"),
            @Mapping(source = "order", target = "order"),
            @Mapping(source = "weight", target = "weight"),
            @Mapping(source = "location_area_encounters", target = "locationAreaEncounters"),
            @Mapping(source = "sprites", target = "sprites"),
            @Mapping(source = "stats", target = "stats"),
            @Mapping(source = "types", target = "types"),
            @Mapping(source = "abilities", target = "abilities")
    })
    PokemonEntity toPokemonEntity(PokemonAPI pokemonAPI);
    List<PokemonEntity> toPokemonEntities(List<PokemonAPI> pokemonAPIS);

    @InheritInverseConfiguration
    PokemonAPI toPokemonAPI(PokemonEntity pokemonEntity);
}
