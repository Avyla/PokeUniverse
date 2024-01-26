package com.porfolioprojects.APokedex.api;


import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PokemonAPI {

    private Integer id;
    private String name;
    private Integer base_experience;
    private Integer height;
    private Boolean is_default;
    private Integer order;
    private Integer weight;
    private String location_area_encounters;
    private SpritesAPI sprites;
    private List<StatsAPI> stats;
    private List<TypesAPI> types;
    private List<AbilitiesAPI> abilities;

}
