package com.porfolioprojects.APokedex.repository;

import com.porfolioprojects.APokedex.entity.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Long> {
    RolEntity findByRol(String rol);
}
