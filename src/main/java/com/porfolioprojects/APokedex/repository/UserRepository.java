package com.porfolioprojects.APokedex.repository;

import com.porfolioprojects.APokedex.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, String> {
}
