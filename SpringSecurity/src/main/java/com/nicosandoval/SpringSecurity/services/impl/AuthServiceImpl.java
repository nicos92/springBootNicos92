package com.nicosandoval.SpringSecurity.services.impl;

import com.nicosandoval.SpringSecurity.persistence.entities.UserEntity;
import com.nicosandoval.SpringSecurity.persistence.repositories.UserRepository;
import com.nicosandoval.SpringSecurity.services.models.dtos.LoginDto;
import com.nicosandoval.SpringSecurity.services.models.dtos.ResponseDto;
import com.nicosandoval.SpringSecurity.services.models.validations.UserValidation;
import com.nimbusds.jose.JOSEException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class AuthServiceImpl implements IAuthService{

    private static Logger LOG = LoggerFactory.getLogger(AuthServiceImpl.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IJWTUtilityService ijwtUtilityService;

    @Autowired
    private UserValidation userValidation;

    @Override
    public HashMap<String,String> login(LoginDto loginDto){
        try {
            HashMap<String,String> jwt = new HashMap<>();
            Optional<UserEntity> user = userRepository.findByEmail(loginDto.getEmail());

            if (user.isEmpty()){
                jwt.put("ERROR", "User not registered!");
                return jwt;
            }

            //verificar la contraseña
            if (verifyPassword(loginDto.getPassword(), user.get().getPassword())){
                jwt.put("jwt", ijwtUtilityService.generateJWT(user.get().getUser_Id()));
            }else {
                jwt.put("ERROR", "Authentication Failed");
            }
            return jwt;

        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException | JOSEException | IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseDto register(UserEntity user) throws Exception {
        try {
            ResponseDto responseDto = userValidation.validate(user);

            if (responseDto.getNumOfErrors() > 0){
                return responseDto;
            }

            List<UserEntity> getAllUsers = userRepository.findAll();

            for (UserEntity repeatFields: getAllUsers){
                if (Objects.equals(repeatFields.getEmail(), user.getEmail())){
                    responseDto.setNumOfErrors(1);
                    responseDto.setMessage("User Already exists!");
                    LOG.debug("que es esto: "+ repeatFields.toString());
                    return responseDto;
                }
            }

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);

            user.setPassword(encoder.encode(user.getPassword()));

            userRepository.save(user);
            responseDto.setMessage("User Created Succesfully!");

            return responseDto;

        }catch (Exception e){
            throw new Exception(e.toString());
        }
    }

    private boolean verifyPassword(String enteredPassword, String storedPassword){
        BCryptPasswordEncoder encoder  = new BCryptPasswordEncoder();
        return encoder.matches(enteredPassword, storedPassword);
    }
}
