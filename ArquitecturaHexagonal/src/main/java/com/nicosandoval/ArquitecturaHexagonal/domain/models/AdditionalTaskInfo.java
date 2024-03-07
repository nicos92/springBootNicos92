package com.nicosandoval.ArquitecturaHexagonal.domain.models;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AdditionalTaskInfo {
    private final Long userId;
    private final String userName;
    private final String userEmail;


}
