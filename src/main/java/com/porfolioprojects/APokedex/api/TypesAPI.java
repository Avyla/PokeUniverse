package com.porfolioprojects.APokedex.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TypesAPI {

    private Integer typesId;
    private Integer slot;
    private TypeAPI type;

}
