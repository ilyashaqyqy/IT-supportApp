package com.ITsupport.support.App.mapper;

import com.ITsupport.support.App.dto.UtilisateurDTO;
import com.ITsupport.support.App.model.Utilisateur;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtilisateurMapper {

    UtilisateurDTO toDTO(Utilisateur utilisateur);
    Utilisateur toEntity(UtilisateurDTO utilisateurDTO);
}

