package com.ITsupport.support.App.mapper;

import com.ITsupport.support.App.dto.TechnicienDTO;
import com.ITsupport.support.App.model.Technicien;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechnicienMapper {

    TechnicienDTO toDTO(Technicien technicien);
    Technicien toEntity(TechnicienDTO technicienDTO);
}
