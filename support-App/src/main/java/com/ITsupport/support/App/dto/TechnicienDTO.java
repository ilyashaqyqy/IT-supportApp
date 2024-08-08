package com.ITsupport.support.App.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TechnicienDTO {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String role;
    private String specialisation;
}
