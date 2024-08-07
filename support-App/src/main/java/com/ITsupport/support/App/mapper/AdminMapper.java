package com.ITsupport.support.App.mapper;

import com.ITsupport.support.App.dto.AdminDTO;
import com.ITsupport.support.App.model.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMapper {

    AdminDTO toDTO(Admin admin);
    Admin toEntity(AdminDTO adminDTO);
}
