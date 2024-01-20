package com.porfolioprojects.APokedex.model;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class UserRolModel {

    private Long userRolId;
    private LocalDateTime grantedDate;
    private RolModel rol;

}
