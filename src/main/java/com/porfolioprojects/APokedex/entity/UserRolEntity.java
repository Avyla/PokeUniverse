package com.porfolioprojects.APokedex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_rol")
@IdClass(UserRolId.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRolEntity {

    @Id
    private String username;

    @Id
    private String rol;

    @Column(name = "granted_date", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime grantedDate;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username", insertable = false, updatable = false)
    private UserEntity user;


}
