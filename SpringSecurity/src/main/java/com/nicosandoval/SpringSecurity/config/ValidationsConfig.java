package com.nicosandoval.SpringSecurity.config;

import com.nicosandoval.SpringSecurity.services.models.validations.UserValidation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationsConfig {

    @Bean
    public UserValidation  userValidation(){
        return new UserValidation();
    }

}
