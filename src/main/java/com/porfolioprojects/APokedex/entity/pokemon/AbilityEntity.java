package com.porfolioprojects.APokedex.entity.pokemon;

import jakarta.persistence.*;
import lombok.*;

import java.net.URL;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ability")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AbilityEntity {

    @Id
    @Column(name = "ability_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer abilityId;

    private String name;

    private String url;

    @OneToMany(mappedBy = "ability")
    private List<AbilitiesEntity> pokemons;

}
