package com.ITsupport.support.App.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {

    private Long id;
    private String nomUtilisateur;
    private String motDePasse;
    private String email;
    private String role;
}
