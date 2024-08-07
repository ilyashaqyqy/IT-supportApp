package com.ITsupport.support.App.mapper;


import com.ITsupport.support.App.dto.EquipementDTO;
import com.ITsupport.support.App.model.Equipement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EquipementMapper {

    EquipementDTO toDTO(Equipement equipement);
    Equipement toEntity(EquipementDTO equipementDTO);
}

