package com.ITsupport.support.App.service.impl;

import com.ITsupport.support.App.dto.TicketSupportDTO;
import com.ITsupport.support.App.mapper.TicketSupportMapper;
import com.ITsupport.support.App.model.*;
import com.ITsupport.support.App.repository.*;
import com.ITsupport.support.App.service.TicketSupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TicketSupportServiceImpl implements TicketSupportService {

    private final TicketSupportRepository ticketSupportRepository;
    private final TicketSupportMapper ticketSupportMapper;
    private final TechnicienRepository technicienRepository;
    private final UtilisateurRepository utilisateurRepository;
    private final EquipementRepository equipementRepository;
    private final PanneRepository panneRepository;

    @Override
    public TicketSupportDTO createTicketSupport(TicketSupportDTO ticketSupportDTO) {
        Utilisateur utilisateur = utilisateurRepository.findById(ticketSupportDTO.getUtilisateurId())
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur not found"));
        Equipement equipment = equipementRepository.findById(ticketSupportDTO.getEquipmentId())
                .orElseThrow(() -> new IllegalArgumentException("Equipment not found"));
        Panne panne = panneRepository.findById(ticketSupportDTO.getPanneId())
                .orElseThrow(() -> new IllegalArgumentException("Panne not found"));

        // Add a check for the technicienAssigneId
        Technicien technicien = null;
        if (ticketSupportDTO.getTechnicienAssigneId() != null) {
            technicien = technicienRepository.findById(ticketSupportDTO.getTechnicienAssigneId())
                    .orElseThrow(() -> new IllegalArgumentException("Technicien not found"));
        }

        TicketSupport ticketSupport = ticketSupportMapper.toEntity(ticketSupportDTO);
        ticketSupport.setUtilisateur(utilisateur);
        ticketSupport.setEquipment(equipment);
        ticketSupport.setPanne(panne);
        ticketSupport.setTechnicienAssigne(technicien);

        TicketSupport savedTicketSupport = ticketSupportRepository.save(ticketSupport);
        return ticketSupportMapper.toDTO(savedTicketSupport);
    }


    @Override
    public TicketSupportDTO updateTicketSupport(Long id, TicketSupportDTO ticketSupportDTO) {
        TicketSupport ticketSupport = ticketSupportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TicketSupport not found"));

        // Manually update fields
        ticketSupport.setDescription(ticketSupportDTO.getDescription());
        ticketSupport.setEtat(TicketStatus.valueOf(ticketSupportDTO.getEtat()));
        ticketSupport.setDateCreation(ticketSupportDTO.getDateCreation());
        ticketSupport.setEquipment(ticketSupport.getEquipment()); //
        ticketSupport.setUtilisateur(ticketSupport.getUtilisateur()); //
        ticketSupport.setTechnicienAssigne(ticketSupport.getTechnicienAssigne()); //

        TicketSupport updatedTicketSupport = ticketSupportRepository.save(ticketSupport);
        return ticketSupportMapper.toDTO(updatedTicketSupport);
    }

    @Override
    public void deleteTicketSupport(Long id) {
        ticketSupportRepository.deleteById(id);
    }

    @Override
    public TicketSupportDTO getTicketSupportById(Long id) {
        TicketSupport ticketSupport = ticketSupportRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TicketSupport not found"));
        return ticketSupportMapper.toDTO(ticketSupport);
    }

    @Override
    public List<TicketSupportDTO> getAllTicketSupports() {
        return ticketSupportRepository.findAll().stream()
                .map(ticketSupportMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void assignTicketToTechnician(Long ticketsupportId, Long technicianId) {
        TicketSupport ticket = ticketSupportRepository.findById(ticketsupportId)
                .orElseThrow(() -> new IllegalArgumentException("TicketSupport not found"));
        Technicien technicien = technicienRepository.findById(technicianId)
                .orElseThrow(() -> new IllegalArgumentException("Technicien not found"));


        ticket.setTechnicienAssigne(technicien);
        ticket.setEtat(TicketStatus.ASSIGNED); // Update the ticket status
        ticketSupportRepository.save(ticket);
    }

    @Override
    public List<TicketSupportDTO> getTicketsByUserId(Long utilisateurId) {
        List<TicketSupport> tickets = ticketSupportRepository.findByUtilisateurId(utilisateurId);
        return tickets.stream()
                .map(ticketSupportMapper::toDTO)
                .collect(Collectors.toList());
    }



}
