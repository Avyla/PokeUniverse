package com.porfolioprojects.APokedex.mapper;

import com.porfolioprojects.APokedex.api.AbilitiesAPI;
import com.porfolioprojects.APokedex.dto.pokemon.AbilitiesDTO;
import com.porfolioprojects.APokedex.entity.pokemon.AbilitiesEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {AbilityMapper.class})
public interface AbilitiesMapper {

    @Mappings({
            @Mapping(source = "abilitiesId", target = "abilitiesId"),
            @Mapping(source = "is_hiden", target = "isHiden"),
            @Mapping(source = "slot", target = "slot"),
            @Mapping(source = "ability", target = "ability"),
            @Mapping(target = "pokemon", ignore = true)
    })
    AbilitiesEntity toAbilitiesEntity(AbilitiesAPI abilitiesAPI);

    @InheritInverseConfiguration
    AbilitiesAPI toAbilitiesAPI(AbilitiesEntity abilitiesEntity);

    @Mappings({
            @Mapping(source = "isHiden", target = "isHiden"),
            @Mapping(source = "slot", target = "slot"),
            @Mapping(source = "ability", target = "ability")
    })
    AbilitiesDTO toAbilitiesDTO(AbilitiesEntity abilitiesEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "abilitiesId", ignore = true),
            @Mapping(target = "pokemon", ignore = true)
    })
    AbilitiesEntity toAbilitiesEntiry(AbilitiesDTO abilitiesDTO);
}
