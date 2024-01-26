package com.porfolioprojects.APokedex.mapper;

import com.porfolioprojects.APokedex.api.TypeAPI;
import com.porfolioprojects.APokedex.entity.pokemon.TypeEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TypeMapper {

    @Mappings({
            @Mapping(source = "typeId", target = "typeId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "url", target = "url"),
            @Mapping(target = "pokemons", ignore = true)
    })
    TypeEntity toTypeEntity(TypeAPI typeAPI);

    @InheritInverseConfiguration
    TypeAPI toTypeAPI(TypeEntity typeEntity);

}
