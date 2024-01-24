package com.porfolioprojects.APokedex.entity.pokemon;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;

@Entity
@Table(name = "sprites")
@Setter
@Getter
public class SpritesEntity {

    @Id
    @Column(name = "sprites_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spritesId;

    @Column(name = "back_default")
    private URL backDefault;

    @Column(name = "back_female")
    private URL backFemale;

    @Column(name = "back_shiny")
    private URL back_shiny;

    @Column(name = "back_shiny_female")
    private URL backShinyFemale;

    @Column(name = "front_default")
    private URL frontDefault;

    @Column(name = "front_female")
    private URL frontFemale;

    @Column(name = "front_shiny")
    private URL frontShiny;

    @Column(name = "front_shiny_female")
    private URL frontShinyFemale;

    @OneToOne(mappedBy = "sprites")
    private PokemonEntity pokemon;

}
