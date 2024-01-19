package com.porfolioprojects.APokedex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 200)
    private String password;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean disabled;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean locked;

    @OneToMany(mappedBy = "user")
    private List<UserRolEntity> roles;

}
