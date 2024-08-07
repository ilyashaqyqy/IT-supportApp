package com.ITsupport.support.App.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class HistoriquePanneDTO {

    private Long id;
    private Long equipmentId;
    private Long panneId;
    private Date reportDate;
    private Date repairDate;
    private String status;
}
