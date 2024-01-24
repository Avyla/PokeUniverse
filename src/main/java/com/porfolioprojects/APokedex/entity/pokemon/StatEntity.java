package com.porfolioprojects.APokedex.entity.pokemon;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.List;

@Entity
@Table(name = "stat")
@Getter
@Setter
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
