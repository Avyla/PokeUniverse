package com.porfolioprojects.APokedex.entity.pokemon;

import jakarta.persistence.*;
import lombok.*;

import java.net.URL;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "stat")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StatEntity {

    @Id
    @Column(name = "stat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statId;

    private String name;

    private String url;

    @OneToMany(mappedBy = "stat")
    private List<StatsEntity> pokemons;

}
