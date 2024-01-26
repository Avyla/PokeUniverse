package com.porfolioprojects.APokedex.mapper;

import com.porfolioprojects.APokedex.api.SpritesAPI;
import com.porfolioprojects.APokedex.entity.pokemon.SpritesEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface SpritesMapper {

    @Mappings({
            @Mapping(source = "spritesId", target = "spritesId"),
            @Mapping(source = "back_default", target = "backDefault"),
            @Mapping(source = "back_female", target = "backFemale"),
            @Mapping(source = "back_shiny", target = "backShiny"),
            @Mapping(source = "back_shiny_female", target = "backShinyFemale"),
            @Mapping(source = "front_default", target = "frontDefault"),
            @Mapping(source = "front_female", target = "frontFemale"),
            @Mapping(source = "front_shiny", target = "frontShiny"),
            @Mapping(source = "front_shinyFemale", target = "frontShinyFemale"),
            @Mapping(target = "pokemon", ignore = true)
    })
    SpritesEntity toSpritesEntity(SpritesAPI spritesAPI);

    @InheritInverseConfiguration
    SpritesAPI toSpritesAPI(SpritesEntity spritesEntity);

}
