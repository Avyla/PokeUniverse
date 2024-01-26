package com.porfolioprojects.APokedex.dto.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AbilitiesDTO {

    private Boolean isHiden;
    private Integer slot;
    private AbilityDTO ability;

}