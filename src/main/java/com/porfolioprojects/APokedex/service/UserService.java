package com.porfolioprojects.APokedex.service;

import com.porfolioprojects.APokedex.dto.UserRegistrationDTO;
import com.porfolioprojects.APokedex.entity.RolEntity;
import com.porfolioprojects.APokedex.entity.UserEntity;
import com.porfolioprojects.APokedex.entity.UserRolEntity;
import com.porfolioprojects.APokedex.mapper.UserMapper;
import com.porfolioprojects.APokedex.model.UserModel;
import com.porfolioprojects.APokedex.repository.RolRepository;
import com.porfolioprojects.APokedex.repository.UserRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final RolRepository rolRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, EntityManager entityManager, RolRepository rolRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
        this.rolRepository = rolRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserModel registerUser(UserRegistrationDTO userRegistrationDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRegistrationDTO.getUsername());
        userEntity.setEmail(userRegistrationDTO.getEmail());
        userEntity.setPassword(this.passwordEncoder(userRegistrationDTO.getPassword()));
        userEntity.setLocked(false);
        userEntity.setDisabled(false);

        // Buscar si el rol ya existe

        RolEntity rolEntity = (RolEntity) rolRepository.findByRol("ADMIN");
        if (rolEntity == null) {
            rolEntity = new RolEntity();
            rolEntity.setRol("ADMIN");
            entityManager.merge(rolEntity);
        }

        UserRolEntity userRolEntity = new UserRolEntity();
        userRolEntity.setGrantedDate(LocalDateTime.now());
        userRolEntity.setRol(rolEntity);
        userRolEntity.setUser(userEntity);

        rolEntity.setUsers(Arrays.asList(userRolEntity));
        userEntity.setRoles(Arrays.asList(userRolEntity));

        return userMapper.toUserModel(userRepository.save(userEntity));
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userMapper.toUserModel(userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User" + username + "Not found")));

        System.out.println(userRepository.findById(username));

        String[] roles = userModel.getRoles().stream()
                .map(userRolModel -> userRolModel.getRol().getRol()) // Asumiendo que UserRolModel tiene una propiedad RolEntity llamada 'rol'
                .toArray(String[]::new);

        return User.builder()
                .username(userModel.getUsername())
                .password(userModel.getPassword())
                .authorities(this.grantedAuthorities(roles))
                .accountLocked(userModel.getLocked())
                .disabled(userModel.getDisabled())
                .build();
    }

    private String[] getAuthorities(String role){
        if("OTRO".equals(role) || "BASIC".equals(role)){
            return new String[] {"ADMINS"};
        }
        return new String[]{};
    }

    private List<GrantedAuthority> grantedAuthorities(String[] roles){
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);

        for (String rol: roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_" + rol));

            for (String authority: this.getAuthorities(rol)){
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }
        return authorities;
    }

    private String passwordEncoder(String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.encode(password);
    }

}
