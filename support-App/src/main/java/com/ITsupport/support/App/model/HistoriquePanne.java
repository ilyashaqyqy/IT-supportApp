package com.ITsupport.support.App.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@Entity
public class HistoriquePanne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipement equipment;

    @ManyToOne
    @JoinColumn(name = "panne_id")
    private Panne panne;

    private Date reportDate;
    private Date repairDate;
    private String status;
}
