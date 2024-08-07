package com.ITsupport.support.App.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class TicketSupport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipement equipment;

    private String description;
    private Date dateCreation;
    private String etat;

    @ManyToOne
    @JoinColumn(name = "technicien_id")
    private Technicien technicienAssigne;
}

