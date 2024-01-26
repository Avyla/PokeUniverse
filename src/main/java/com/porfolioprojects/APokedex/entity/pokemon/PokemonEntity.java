package com.porfolioprojects.APokedex.entity.pokemon;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.net.URL;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "pokemon")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonEntity {

    @Id
    @Column(name = "pokemon_id")
    private Integer pokemonId;

    private String name;

    @Column(name = "base_experience")
    private Integer baseExperience;

    private Integer height;

    @Column(name = "is_default")
    private Boolean isDefault;

    @Column(name = "`order`")
    private Integer order;

    private Integer weight;

    @Column(name = "location_area_encounters")
    private String locationAreaEncounters;

    @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinColumn(name = "sprites_id", referencedColumnName = "sprites_id")
    private SpritesEntity sprites;

    @OneToMany(mappedBy = "pokemon", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<StatsEntity> stats;

    @OneToMany(mappedBy = "pokemon", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<TypesEntity> types;

    @OneToMany(mappedBy = "pokemon", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<AbilitiesEntity> abilities;

}
