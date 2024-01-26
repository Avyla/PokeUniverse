package com.porfolioprojects.APokedex.entity.pokemon;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "stats")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StatsEntity {

    @Id
    @Column(name = "stats_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statsId;

    @Column(name = "base_stat")
    private Integer baseStat;

    private Integer effort;

    @ManyToOne
    @JoinColumn(name = "stats_stat_id")
    private StatEntity stat;

    @ManyToOne
    @JoinColumn(name = "stats_pokemon_id")
    private PokemonEntity pokemon;

}
