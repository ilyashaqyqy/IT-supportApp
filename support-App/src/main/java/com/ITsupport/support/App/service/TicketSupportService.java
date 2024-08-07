package com.ITsupport.support.App.service;

import com.ITsupport.support.App.dto.TicketSupportDTO;
import java.util.List;

public interface TicketSupportService {
    TicketSupportDTO createTicketSupport(TicketSupportDTO ticketSupportDTO);
    TicketSupportDTO updateTicketSupport(Long id, TicketSupportDTO ticketSupportDTO);
    void deleteTicketSupport(Long id);
    TicketSupportDTO getTicketSupportById(Long id);
    List<TicketSupportDTO> getAllTicketSupports();
    void assignTicketToTechnician(Long ticketId, Long technicianId);
}
