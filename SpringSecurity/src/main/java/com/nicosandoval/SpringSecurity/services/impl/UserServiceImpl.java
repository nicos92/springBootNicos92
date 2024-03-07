package com.nicosandoval.SpringSecurity.services.impl;

import com.nicosandoval.SpringSecurity.persistence.entities.UserEntity;
import com.nicosandoval.SpringSecurity.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    UserRepository userRepository;
    @Override
    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }
}
