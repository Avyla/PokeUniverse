package com.porfolioprojects.APokedex.repository;

import com.porfolioprojects.APokedex.entity.pokemon.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository extends JpaRepository<TypeEntity, Integer> {
    TypeEntity findByName(String name);
}
