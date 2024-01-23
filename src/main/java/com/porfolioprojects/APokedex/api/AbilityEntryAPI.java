package com.porfolioprojects.APokedex.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AbilityEntryAPI {

    private Boolean is_hiden;
    private Integer slot;
    private AbilityAPI ability;

}
