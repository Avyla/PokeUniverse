package com.porfolioprojects.APokedex.repository;

import com.porfolioprojects.APokedex.api.PokemonAPI;
import com.porfolioprojects.APokedex.dto.pokemon.projection.PokemonProjection;
import com.porfolioprojects.APokedex.entity.pokemon.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Integer> {

    @Query("select p from PokemonEntity p where p.name = ?1")
    Optional<PokemonEntity> findByName(String name);

    @Query(value = "SELECT p.name AS name, " +
            "p.pokemon_id AS PokemonId, " +
            "s.front_default AS frontDefault, " +
            "t.name AS type " +
            "FROM pokemon p " +
            "JOIN sprites s ON p.sprites_id = s.sprites_id " +
            "JOIN types ts ON p.pokemon_id = ts.types_pokemon_id " +
            "JOIN type t ON ts.types_type_id = t.type_id " +
            "ORDER BY RAND() " +
            "LIMIT 20", nativeQuery = true)
    Optional<Set<PokemonProjection>> generateHome();

    @Query(value = "SELECT p.name AS name, " +
            "p.pokemon_id AS PokemonId, " +
            "s.front_default AS frontDefault, " +
            "t.name AS type " +
            "FROM pokemon p " +
            "JOIN sprites s ON p.sprites_id = s.sprites_id " +
            "JOIN types ts ON p.pokemon_id = ts.types_pokemon_id " +
            "JOIN type t ON ts.types_type_id = t.type_id " +
            "WHERE t.name = :type " +
            "ORDER BY RAND() " +
            "LIMIT 20", nativeQuery = true)
    Optional<Set<PokemonProjection>> generateHomeByType(@Param("type") String type);

}
