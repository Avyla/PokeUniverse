package com.porfolioprojects.APokedex.entity.pokemon;

import com.porfolioprojects.APokedex.api.AbilityAPI;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "abilities")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AbilitiesEntity {

    @Id
    @Column(name = "abilities_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer abilitiesId;

    @Column(name = "id_hiden", columnDefinition = "TINYINT")
    private Boolean isHiden;

    private Integer slot;

    @ManyToOne
    @JoinColumn(name = "abilities_ability_id")
    private AbilityEntity ability;

    @ManyToOne
    @JoinColumn(name = "abilities_pokemon_id")
    private PokemonEntity pokemon;

}
