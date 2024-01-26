package com.porfolioprojects.APokedex.repository;

import com.porfolioprojects.APokedex.entity.pokemon.AbilitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilitiesRepository extends JpaRepository<AbilitiesEntity, Integer> {
}
