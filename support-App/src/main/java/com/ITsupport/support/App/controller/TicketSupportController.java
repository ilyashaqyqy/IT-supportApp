package com.ITsupport.support.App.controller;

import com.ITsupport.support.App.dto.TicketSupportDTO;
import com.ITsupport.support.App.service.TicketSupportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@RequiredArgsConstructor
public class TicketSupportController {

    private final TicketSupportService ticketSupportService;

    @PostMapping
    public ResponseEntity<TicketSupportDTO> createTicketSupport(@RequestBody TicketSupportDTO ticketSupportDTO) {
        TicketSupportDTO createdTicketSupport = ticketSupportService.createTicketSupport(ticketSupportDTO);
        return ResponseEntity.ok(createdTicketSupport);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketSupportDTO> updateTicketSupport(@PathVariable Long id, @RequestBody TicketSupportDTO ticketSupportDTO) {
        TicketSupportDTO updatedTicketSupport = ticketSupportService.updateTicketSupport(id, ticketSupportDTO);
        return ResponseEntity.ok(updatedTicketSupport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketSupport(@PathVariable Long id) {
        ticketSupportService.deleteTicketSupport(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketSupportDTO> getTicketSupportById(@PathVariable Long id) {
        TicketSupportDTO ticketSupportDTO = ticketSupportService.getTicketSupportById(id);
        return ResponseEntity.ok(ticketSupportDTO);
    }

    @GetMapping
    public ResponseEntity<List<TicketSupportDTO>> getAllTicketSupports() {
        List<TicketSupportDTO> ticketSupports = ticketSupportService.getAllTicketSupports();
        return ResponseEntity.ok(ticketSupports);
    }

    @PutMapping("/{ticketsupportId}/assign/{technicianId}")
    public ResponseEntity<Void> assignTicket(@PathVariable Long ticketsupportId, @PathVariable Long technicianId) {
        ticketSupportService.assignTicketToTechnician(ticketsupportId, technicianId);
        return ResponseEntity.noContent().build();
    }

}
