package com.nicosandoval.SpringSecurity.services.impl;

import com.nicosandoval.SpringSecurity.persistence.entities.UserEntity;

import java.util.List;

public interface IUserService {
    public List<UserEntity> findAllUsers();
}
