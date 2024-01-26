package com.porfolioprojects.APokedex.entity.pokemon;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "types")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TypesEntity {

    @Id
    @Column(name = "types_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typesId;

    private Integer slot;

    @ManyToOne
    @JoinColumn(name = "types_type_id", updatable = true,insertable = true)
    private TypeEntity type;

    @ManyToOne
    @JoinColumn(name = "types_pokemon_id", referencedColumnName = "pokemon_id")
    private PokemonEntity pokemon;

}
