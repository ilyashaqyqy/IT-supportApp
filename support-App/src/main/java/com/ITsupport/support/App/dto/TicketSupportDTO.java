package com.ITsupport.support.App.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter

public class TicketSupportDTO {

    private Long id;
    private Long utilisateurId;
    private Long equipmentId;
    private String description;
    private Date dateCreation;
    private String etat;
    private Long technicienAssigneId;
}
