package com.ITsupport.support.App.model;



import jakarta.persistence.*;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Panne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private Equipement equipment;

    private String description;
    private Date reportDate;
    private Date repairDate;
    private String status;

    @OneToMany(mappedBy = "panne")
    private List<HistoriquePanne> historiquePannes;
}
