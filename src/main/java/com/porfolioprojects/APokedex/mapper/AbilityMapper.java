package com.porfolioprojects.APokedex.mapper;

import com.porfolioprojects.APokedex.api.AbilityAPI;
import com.porfolioprojects.APokedex.dto.pokemon.AbilityDTO;
import com.porfolioprojects.APokedex.entity.pokemon.AbilityEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface AbilityMapper {

    @Mappings({
            @Mapping(source = "abilityId", target = "abilityId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "url", target = "url"),
            @Mapping(target = "pokemons", ignore = true)
    })
    AbilityEntity toAbilityEntity(AbilityAPI abilityAPI);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "url", target = "url"),
    })
    AbilityDTO toAbilityDTO(AbilityEntity abilityEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "abilityId", ignore = true),
            @Mapping(target = "pokemons", ignore = true),
    })
    AbilityEntity toAbilityEntity(AbilityDTO abilityDTO);

}
