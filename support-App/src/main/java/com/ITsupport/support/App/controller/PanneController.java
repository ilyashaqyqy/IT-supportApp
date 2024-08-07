package com.ITsupport.support.App.controller;

import com.ITsupport.support.App.dto.PanneDTO;
import com.ITsupport.support.App.service.PanneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pannes")
@RequiredArgsConstructor
public class PanneController {

    private final PanneService panneService;

    @PostMapping
    public ResponseEntity<PanneDTO> createPanne(@RequestBody PanneDTO panneDTO) {
        PanneDTO createdPanne = panneService.createPanne(panneDTO);
        return ResponseEntity.ok(createdPanne);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PanneDTO> updatePanne(@PathVariable Long id, @RequestBody PanneDTO panneDTO) {
        PanneDTO updatedPanne = panneService.updatePanne(id, panneDTO);
        return ResponseEntity.ok(updatedPanne);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePanne(@PathVariable Long id) {
        panneService.deletePanne(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PanneDTO> getPanneById(@PathVariable Long id) {
        PanneDTO panneDTO = panneService.getPanneById(id);
        return ResponseEntity.ok(panneDTO);
    }

    @GetMapping
    public ResponseEntity<List<PanneDTO>> getAllPannes() {
        List<PanneDTO> pannes = panneService.getAllPannes();
        return ResponseEntity.ok(pannes);
    }
}
