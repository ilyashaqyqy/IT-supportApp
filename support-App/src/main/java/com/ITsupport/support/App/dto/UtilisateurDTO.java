package com.ITsupport.support.App.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UtilisateurDTO {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;
}
