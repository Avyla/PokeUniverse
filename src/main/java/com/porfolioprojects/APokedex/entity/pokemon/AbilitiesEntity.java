package com.porfolioprojects.APokedex.entity.pokemon;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "abilities")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AbilitiesEntity {

    @Id
    @Column(name = "abilities_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer abilitiesId;

    @Column(name = "id_hidden", columnDefinition = "TINYINT")
    private Boolean isHidden;

    private Integer slot;

    @ManyToOne
    @JoinColumn(name = "abilities_ability_id")
    private AbilityEntity ability;

    @ManyToOne
    @JoinColumn(name = "abilities_pokemon_id")
    private PokemonEntity pokemon;

}
