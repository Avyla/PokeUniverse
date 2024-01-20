package com.porfolioprojects.APokedex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "rol")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolEntity {

    @Id
    @Column(name = "rol_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rolId;

    @Column(name = "rol", length = 50)
    private String rol;

    @OneToMany(mappedBy = "rol", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private List<UserRolEntity> users;
}
