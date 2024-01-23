package com.porfolioprojects.APokedex.api;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonAPI {

    private Integer id;
    private String name;
    private Integer base_experience;
    private Integer height;
    private Boolean is_default;
    private Integer order;
    private Integer weight;
    private URL location_area_encounters;
    private SpritesAPI sprites;
    private List<StatsAPI> stats;
    private List<TypesAPI> types;
    private List<AbilityEntryAPI> abilities;

}
