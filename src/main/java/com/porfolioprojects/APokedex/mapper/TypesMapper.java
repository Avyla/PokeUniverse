package com.porfolioprojects.APokedex.mapper;

import com.porfolioprojects.APokedex.api.TypesAPI;
import com.porfolioprojects.APokedex.entity.pokemon.TypesEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {TypeMapper.class})
public interface TypesMapper {

    @Mappings({
            @Mapping(source = "typesId", target = "typesId"),
            @Mapping(source = "slot", target = "slot"),
            @Mapping(source = "type", target = "type"),
            @Mapping(target = "pokemon", ignore = true)
    })
    TypesEntity toTypesEntity(TypesAPI typesAPI);

    @InheritInverseConfiguration
    TypesAPI toTypesAPI(TypesEntity typesEntity);

}
