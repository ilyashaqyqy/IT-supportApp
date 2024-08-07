package com.ITsupport.support.App.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class EquipementDTO {

    private Long id;
    private String name;
    private String description;
    private String status;
    private String location;
    private Date purchaseDate;
}
