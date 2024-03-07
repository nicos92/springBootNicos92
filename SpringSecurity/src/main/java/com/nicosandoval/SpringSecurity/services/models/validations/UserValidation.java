package com.nicosandoval.SpringSecurity.services.models.validations;

import com.nicosandoval.SpringSecurity.persistence.entities.UserEntity;
import com.nicosandoval.SpringSecurity.services.models.dtos.ResponseDto;

public class UserValidation {
    public ResponseDto validate(UserEntity user) {
        ResponseDto responseDto = new ResponseDto();

        responseDto.setNumOfErrors(0);
        if (user.getFirstName() == null ||
                user.getFirstName().length() < 2 ||
                user.getFirstName().length() > 255) {
            responseDto.setNumOfErrors(responseDto.getNumOfErrors() + 1);
            responseDto.setMessage("fist name invalido");
        }

        if (user.getLastName() == null ||
                user.getLastName().length() < 2 ||
                user.getLastName().length() > 255) {
            responseDto.setNumOfErrors(responseDto.getNumOfErrors() + 1);
            responseDto.setMessage("last name invalido");
        }

        if (user.getEmail() == null ||
                user.getEmail().length() < 2 ||
                user.getEmail().length() > 255 ||
                !user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            responseDto.setNumOfErrors(responseDto.getNumOfErrors() + 1);
            responseDto.setMessage("email invalido");
        }

        if (user.getPassword() == null ||
                user.getPassword().length() < 2 ||
                user.getPassword().length() > 255 ||
                !user.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")) {
            responseDto.setNumOfErrors(responseDto.getNumOfErrors() + 1);
            responseDto.setMessage("password invalido, debe tener entre 8 y 16 caracteres, al menos un numero, una minuscula, una mayuscula");
        }


        return responseDto;
    }
}
