package com.nicosandoval.SpringSecurity.controllers;

import com.nicosandoval.SpringSecurity.persistence.entities.UserEntity;
import com.nicosandoval.SpringSecurity.services.impl.IAuthService;
import com.nicosandoval.SpringSecurity.services.models.dtos.LoginDto;
import com.nicosandoval.SpringSecurity.services.models.dtos.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    IAuthService authService;

    @PostMapping("/register")
    private ResponseEntity<ResponseDto> register(@RequestBody UserEntity user) throws Exception {
        return new ResponseEntity<>(authService.register(user), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    private ResponseEntity<HashMap<String,String>> login(@RequestBody LoginDto loginDto){
        HashMap<String,String> login = authService.login(loginDto);
        if (login.containsKey("jwt")){
            return new ResponseEntity<>(login, HttpStatus.OK);
        }
        return new ResponseEntity<>(login, HttpStatus.UNAUTHORIZED);
    }


}
