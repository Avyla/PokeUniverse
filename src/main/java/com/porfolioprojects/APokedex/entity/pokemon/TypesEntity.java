package com.porfolioprojects.APokedex.entity.pokemon;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "types")
@Setter
@Getter
public class TypesEntity {

    @Id
    @Column(name = "types_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typesId;

    private Integer slot;

    @ManyToOne
    @JoinColumn(name = "types_type_id")
    private TypeEntity type;

    @ManyToOne
    @JoinColumn(name = "types_pokemon_id", referencedColumnName = "pokemon_id")
    private PokemonEntity pokemon;

}
