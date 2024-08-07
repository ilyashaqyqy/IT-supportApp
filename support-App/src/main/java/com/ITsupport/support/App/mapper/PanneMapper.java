package com.ITsupport.support.App.mapper;

import com.ITsupport.support.App.dto.PanneDTO;
import com.ITsupport.support.App.model.Panne;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PanneMapper {

    @Mapping(source = "equipment.id", target = "equipmentId")
    PanneDTO toDTO(Panne panne);

    @Mapping(source = "equipmentId", target = "equipment.id")
    Panne toEntity(PanneDTO panneDTO);
}

