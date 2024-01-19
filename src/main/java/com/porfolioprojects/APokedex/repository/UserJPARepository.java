package com.porfolioprojects.APokedex.repository;

import com.porfolioprojects.APokedex.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPARepository extends JpaRepository<UserEntity, String> {
}
