package com.porfolioprojects.APokedex.repository;

import com.porfolioprojects.APokedex.entity.pokemon.StatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatsRepository extends JpaRepository<StatsEntity, Integer> {
}
