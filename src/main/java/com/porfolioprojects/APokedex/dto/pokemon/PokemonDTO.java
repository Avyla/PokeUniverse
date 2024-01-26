package com.porfolioprojects.APokedex.dto.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PokemonDTO {

    private Integer pokemonId;
    private String pokemonName;
    private Integer baseExperience;
    private Integer height;
    private Boolean isDefault;
    private Integer order;
    private Integer weight;
    private String locationAreaEncounters;
    private SpritesDTO sprites;
    private List<StatsDTO> stats;
    private List<TypesDTO> types;
    private List<AbilitiesDTO> abilities;

}
