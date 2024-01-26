package com.porfolioprojects.APokedex.mapper;

import com.porfolioprojects.APokedex.api.StatAPI;
import com.porfolioprojects.APokedex.dto.pokemon.StatDTO;
import com.porfolioprojects.APokedex.entity.pokemon.StatEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface StatMapper {

    @Mappings({
            @Mapping(source = "statId", target = "statId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "url", target = "url"),
            @Mapping(target = "pokemons", ignore = true)
    })
    StatEntity toStatEntity(StatAPI statAPI);

    @InheritInverseConfiguration
    StatAPI toStatAPI(StatEntity statEntity);

    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "url", target = "url")
    })
    StatDTO toStatDTO(StatEntity statEntity);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "statId", ignore = true),
            @Mapping(target = "pokemons", ignore = true)
    })
    StatEntity toStatEntity(StatDTO statDTO);

}
