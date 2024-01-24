package com.porfolioprojects.APokedex.entity.pokemon;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.net.URL;
import java.util.List;

@Entity
@Table(name = "type")
@Setter
@Getter
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
