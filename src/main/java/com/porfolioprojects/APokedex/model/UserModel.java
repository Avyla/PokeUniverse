package com.porfolioprojects.APokedex.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;
@Data
@ToString
public class UserModel {

    private String username;
    private String password;
    private String email;
    private Boolean locked;
    private Boolean disabled;
    private List<UserRolModel> roles;

}
