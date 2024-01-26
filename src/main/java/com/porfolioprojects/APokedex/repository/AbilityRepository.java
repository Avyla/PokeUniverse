package com.porfolioprojects.APokedex.repository;

import com.porfolioprojects.APokedex.entity.pokemon.AbilityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbilityRepository extends JpaRepository<AbilityEntity, Integer> {
    AbilityEntity findByName(String name);
}
