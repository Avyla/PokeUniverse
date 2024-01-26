package com.porfolioprojects.APokedex.dto.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StatsDTO {

    private Integer baseStat;
    private Integer effort;
    private StatDTO stat;

}
