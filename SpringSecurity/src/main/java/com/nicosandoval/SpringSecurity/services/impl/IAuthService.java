package com.nicosandoval.SpringSecurity.services.impl;

import com.nicosandoval.SpringSecurity.persistence.entities.UserEntity;
import com.nicosandoval.SpringSecurity.services.models.dtos.LoginDto;
import com.nicosandoval.SpringSecurity.services.models.dtos.ResponseDto;

import java.util.HashMap;

public interface IAuthService {
    public HashMap<String,String> login(LoginDto loginDto);

    public ResponseDto register(UserEntity user) throws Exception;
}
