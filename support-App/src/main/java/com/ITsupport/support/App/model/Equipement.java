package com.ITsupport.support.App.model;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class Equipement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String status;
    private String location;
    private Date purchaseDate;

    @OneToMany(mappedBy = "equipment")
    private List<Panne> pannes;

    @OneToMany(mappedBy = "equipment")
    private List<HistoriquePanne> historiquePannes;
}
