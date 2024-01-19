package com.porfolioprojects.APokedex.repository;

import com.porfolioprojects.APokedex.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface UserModelRepository {

    Optional<List<UserModel>> getAll();
    Optional<UserModel> getByUsername(String username);
    UserModel save(UserModel userModel);

}
