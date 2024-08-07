package com.ITsupport.support.App.mapper;

import com.ITsupport.support.App.dto.TicketSupportDTO;
import com.ITsupport.support.App.model.TicketSupport;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TicketSupportMapper {

    @Mapping(source = "utilisateur.id", target = "utilisateurId")
    @Mapping(source = "equipment.id", target = "equipmentId")
    @Mapping(source = "technicienAssigne.id", target = "technicienAssigneId")
    TicketSupportDTO toDTO(TicketSupport ticketSupport);

    @Mapping(source = "utilisateurId", target = "utilisateur.id")
    @Mapping(source = "equipmentId", target = "equipment.id")
    @Mapping(source = "technicienAssigneId", target = "technicienAssigne.id")
    TicketSupport toEntity(TicketSupportDTO ticketSupportDTO);
}
