package com.nicosandoval.SpringSecurity.controllers;

import com.nicosandoval.SpringSecurity.persistence.entities.UserEntity;
import com.nicosandoval.SpringSecurity.services.impl.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;
    @GetMapping("/find-all-user")
    private ResponseEntity<List<UserEntity>> getAllUsers(){
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }
}
