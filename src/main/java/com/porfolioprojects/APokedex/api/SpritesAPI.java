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
public class SpritesAPI {

    private URL back_default;
    private URL back_female;
    private URL back_shiny;
    private URL back_shiny_female;
    private URL front_default;
    private URL front_female;
    private URL front_shiny;
    private URL front_shiny_female;

}
