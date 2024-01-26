package com.porfolioprojects.APokedex.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TypeAPI {

    private Integer typeId;
    private String name;
    private String url;

}
