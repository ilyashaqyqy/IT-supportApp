package com.ITsupport.support.App.controller;

import com.ITsupport.support.App.dto.TicketSupportDTO;
import com.ITsupport.support.App.service.TicketSupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketSupportController {

    private final TicketSupportService ticketSupportService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<TicketSupportDTO> createTicketSupport(@RequestBody TicketSupportDTO ticketSupportDTO) {
        TicketSupportDTO createdTicketSupport = ticketSupportService.createTicketSupport(ticketSupportDTO);
        return ResponseEntity.ok(createdTicketSupport);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('TECHNICIAN')")
    @PutMapping("/{id}")
    public ResponseEntity<TicketSupportDTO> updateTicketSupport(@PathVariable Long id, @RequestBody TicketSupportDTO ticketSupportDTO) {
        TicketSupportDTO updatedTicketSupport = ticketSupportService.updateTicketSupport(id, ticketSupportDTO);
        return ResponseEntity.ok(updatedTicketSupport);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketSupport(@PathVariable Long id) {
        ticketSupportService.deleteTicketSupport(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN') or hasRole('TECHNICIAN')")
    @GetMapping("/{id}")
    public ResponseEntity<TicketSupportDTO> getTicketSupportById(@PathVariable Long id) {
        TicketSupportDTO ticketSupportDTO = ticketSupportService.getTicketSupportById(id);
        return ResponseEntity.ok(ticketSupportDTO);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('TECHNICIAN')")
    @GetMapping
    public ResponseEntity<List<TicketSupportDTO>> getAllTicketSupports() {
        List<TicketSupportDTO> ticketSupports = ticketSupportService.getAllTicketSupports();
        return ResponseEntity.ok(ticketSupports);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{ticketsupportId}/assign/{technicianId}")
    public ResponseEntity<Void> assignTicket(@PathVariable Long ticketsupportId, @PathVariable Long technicianId) {
        ticketSupportService.assignTicketToTechnician(ticketsupportId, technicianId);
        return ResponseEntity.noContent().build();
    }
}
