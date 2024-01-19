package com.porfolioprojects.APokedex.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRolModel {

    private String username;
    private String rol;
    private LocalDateTime grantedDate;

}
