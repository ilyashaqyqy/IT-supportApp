package com.ITsupport.support.App.controller;

import com.ITsupport.support.App.dto.TechnicienDTO;
import com.ITsupport.support.App.service.TechnicienService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;


import java.util.List;

@RestController
@RequestMapping("/api/techniciens")
@RequiredArgsConstructor
public class TechnicienController {

    private final TechnicienService technicienService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<TechnicienDTO> createTechnicien(@RequestBody TechnicienDTO technicienDTO) {
        TechnicienDTO createdTechnicien = technicienService.createTechnicien(technicienDTO);
        return ResponseEntity.ok(createdTechnicien);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TechnicienDTO> updateTechnicien(@PathVariable Long id, @RequestBody TechnicienDTO technicienDTO) {
        TechnicienDTO updatedTechnicien = technicienService.updateTechnicien(id, technicienDTO);
        return ResponseEntity.ok(updatedTechnicien);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechnicien(@PathVariable Long id) {
        technicienService.deleteTechnicien(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ROLE_TECHNICIEN') or hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<TechnicienDTO> getTechnicienById(@PathVariable Long id) {
        TechnicienDTO technicienDTO = technicienService.getTechnicienById(id);
        return ResponseEntity.ok(technicienDTO);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<TechnicienDTO>> getAllTechniciens() {
        List<TechnicienDTO> techniciens = technicienService.getAllTechniciens();
        return ResponseEntity.ok(techniciens);
    }
}
