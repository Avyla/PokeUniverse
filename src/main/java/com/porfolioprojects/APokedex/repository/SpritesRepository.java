package com.porfolioprojects.APokedex.repository;

import com.porfolioprojects.APokedex.entity.pokemon.SpritesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpritesRepository extends JpaRepository<SpritesEntity, Integer> {
}
