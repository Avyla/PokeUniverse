package com.porfolioprojects.APokedex.dto.pokemon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TypesDTO {

    private Integer slot;
    private TypeDTO type;

}
