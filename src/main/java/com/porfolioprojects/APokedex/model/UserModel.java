package com.porfolioprojects.APokedex.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {

    private String username;
    private String email;
    private String password;
    private Boolean disabled;
    private Boolean locked;
    private List<UserRolModel> roles;

}
