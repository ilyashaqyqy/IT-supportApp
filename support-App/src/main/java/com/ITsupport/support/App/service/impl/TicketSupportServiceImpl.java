package com.ITsupport.support.App.service.impl;

import com.ITsupport.support.App.dto.TicketSupportDTO;
import com.ITsupport.support.App.mapper.TicketSupportMapper;
import com.ITsupport.support.App.model.Technicien;
import com.ITsupport.support.App.model.TicketStatus;
import com.ITsupport.support.App.model.TicketSupport;
import com.ITsupport.support.App.repository.TechnicienRepository;
import com.ITsupport.support.App.repository.TicketSupportRepository;
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

    @Override
    public TicketSupportDTO createTicketSupport(TicketSupportDTO ticketSupportDTO) {
        TicketSupport ticketSupport = ticketSupportMapper.toEntity(ticketSupportDTO);
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
    public void assignTicketToTechnician(Long ticketId, Long technicianId) {
        TicketSupport ticket = ticketSupportRepository.findById(ticketId)
                .orElseThrow(() -> new IllegalArgumentException("TicketSupport not found"));
        Technicien technicien = technicienRepository.findById(technicianId)
                .orElseThrow(() -> new IllegalArgumentException("Technicien not found"));


        ticket.setTechnicienAssigne(technicien);
        ticket.setEtat(TicketStatus.ASSIGNED); // Update the ticket status
        ticketSupportRepository.save(ticket);
    }


}
