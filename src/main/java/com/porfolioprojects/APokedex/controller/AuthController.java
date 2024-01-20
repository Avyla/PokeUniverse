package com.porfolioprojects.APokedex.controller;

import com.porfolioprojects.APokedex.dto.LoginDTO;
import com.porfolioprojects.APokedex.dto.UserRegistrationDTO;
import com.porfolioprojects.APokedex.model.UserModel;
import com.porfolioprojects.APokedex.security.JwtUtils;
import com.porfolioprojects.APokedex.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginDTO loginDto){
        UsernamePasswordAuthenticationToken login  =
                new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);

        String jwt = jwtUtils.create(loginDto.getUsername());
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwt).build();
    }

    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody UserRegistrationDTO userRegistrationDTO){
        UserModel userModel = userService.registerUser(userRegistrationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userModel);
    }

}
