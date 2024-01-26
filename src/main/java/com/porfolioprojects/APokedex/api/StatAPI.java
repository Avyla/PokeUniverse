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
public class StatAPI {

    private Integer statId;
    private String name;
    private String url;

}
