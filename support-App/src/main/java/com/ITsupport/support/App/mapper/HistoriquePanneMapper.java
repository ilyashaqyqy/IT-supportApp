package com.ITsupport.support.App.mapper;

import com.ITsupport.support.App.dto.HistoriquePanneDTO;
import com.ITsupport.support.App.model.HistoriquePanne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HistoriquePanneMapper {

    @Mapping(source = "equipment.id", target = "equipmentId")
    @Mapping(source = "panne.id", target = "panneId")
    HistoriquePanneDTO toDTO(HistoriquePanne historiquePanne);

    @Mapping(source = "equipmentId", target = "equipment.id")
    @Mapping(source = "panneId", target = "panne.id")
    HistoriquePanne toEntity(HistoriquePanneDTO historiquePanneDTO);
}
