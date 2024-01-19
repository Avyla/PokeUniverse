package com.porfolioprojects.APokedex.repository;

import com.porfolioprojects.APokedex.mapper.UserMapper;
import com.porfolioprojects.APokedex.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements UserModelRepository {

    private final UserMapper userMapper;
    private final UserJPARepository userJPARepository;

    @Autowired
    public UserRepository(UserMapper userMapper, UserJPARepository userJPARepository) {
        this.userMapper = userMapper;
        this.userJPARepository = userJPARepository;
    }

    @Override
    public Optional<List<UserModel>> getAll() {
        return Optional.empty();
    }



    @Override
    public Optional<UserModel> getByUsername(String username) {
        return Optional.ofNullable(userJPARepository.findById(username)
                .map(userMapper::toUserModel)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }

    @Override
    public UserModel save(UserModel userModel) {
        return null;
    }
}
