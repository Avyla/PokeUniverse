package com.porfolioprojects.APokedex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_rol")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_rol_id")
    private Long userRolId;

    @Column(name = "granted_date", columnDefinition = "DATETIME")
    private LocalDateTime grantedDate;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "username")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id")
    private RolEntity rol;

}
