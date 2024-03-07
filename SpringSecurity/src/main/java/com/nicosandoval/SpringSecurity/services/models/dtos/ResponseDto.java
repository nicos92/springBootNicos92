package com.nicosandoval.SpringSecurity.services.models.dtos;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseDto {

    private int numOfErrors;
    private String message;

    public ResponseDto() {
    }

    public ResponseDto(int numOfErrors, String message) {
        this.numOfErrors = numOfErrors;
        this.message = message;
    }
}
