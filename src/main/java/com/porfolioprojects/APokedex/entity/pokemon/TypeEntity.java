package com.porfolioprojects.APokedex.entity.pokemon;

import jakarta.persistence.*;
import lombok.*;

import java.net.URL;
import java.util.List;

@Entity
@Table(name = "type")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeEntity {

    @Id
    @Column(name = "type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;

    private String name;

    private String url;

    @OneToMany(mappedBy = "type")
    private List<TypesEntity> pokemons;

}