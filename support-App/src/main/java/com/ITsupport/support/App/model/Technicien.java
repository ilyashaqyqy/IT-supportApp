package com.ITsupport.support.App.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Technicien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomUtilisateur;
    private String motDePasse;
    private String email;
    private String role;
    private String specialisation;

    @OneToMany(mappedBy = "technicienAssigne")
    private List<TicketSupport> tickets;
}

