package com.ITsupport.support.App.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UtilisateurDTO {

    private Long id;
    private String nomUtilisateur;
    private String motDePasse;
    private String email;
    private String role;
}
