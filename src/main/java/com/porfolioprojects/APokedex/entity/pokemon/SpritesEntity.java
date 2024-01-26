package com.porfolioprojects.APokedex.entity.pokemon;

import jakarta.persistence.*;
import lombok.*;

import java.net.URL;
import java.util.Objects;

@Entity
@Table(name = "sprites")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SpritesEntity {

    @Id
    @Column(name = "sprites_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spritesId;

    @Column(name = "back_default")
    private String backDefault;

    @Column(name = "back_female")
    private String backFemale;

    @Column(name = "back_shiny")
    private String backShiny;

    @Column(name = "back_shiny_female")
    private String backShinyFemale;

    @Column(name = "front_default")
    private String frontDefault;

    @Column(name = "front_female")
    private String frontFemale;

    @Column(name = "front_shiny")
    private String frontShiny;

    @Column(name = "front_shiny_female")
    private String frontShinyFemale;

    @OneToOne(mappedBy = "sprites", cascade = {CascadeType.ALL})
    private PokemonEntity pokemon;

}
