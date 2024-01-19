package com.porfolioprojects.APokedex.service;

import com.porfolioprojects.APokedex.entity.UserEntity;
import com.porfolioprojects.APokedex.entity.UserRolEntity;
import com.porfolioprojects.APokedex.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User" + username + "Not found"));

        String[] roles = userEntity.getRoles()
                .stream()
                .map(UserRolEntity::getRol)
                .toArray(String[]::new);

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(this.grantedAuthorities(roles))
                .accountLocked(userEntity.getLocked())
                .disabled(userEntity.getDisabled())
                .build();
    }

    private String[] getAuthorities(String role){
        if("ADMIN".equals(role) || "BASIC".equals(role)){
            return new String[] {" "};
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

}
