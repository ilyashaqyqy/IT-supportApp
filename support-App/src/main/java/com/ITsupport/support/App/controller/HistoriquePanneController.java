package com.ITsupport.support.App.controller;

import com.ITsupport.support.App.dto.HistoriquePanneDTO;
import com.ITsupport.support.App.service.HistoriquePanneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historique-pannes")
@RequiredArgsConstructor
public class HistoriquePanneController {

    private final HistoriquePanneService historiquePanneService;

    @PostMapping
    public ResponseEntity<HistoriquePanneDTO> createHistoriquePanne(@RequestBody HistoriquePanneDTO historiquePanneDTO) {
        HistoriquePanneDTO createdHistoriquePanne = historiquePanneService.createHistoriquePanne(historiquePanneDTO);
        return ResponseEntity.ok(createdHistoriquePanne);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriquePanneDTO> updateHistoriquePanne(@PathVariable Long id, @RequestBody HistoriquePanneDTO historiquePanneDTO) {
        HistoriquePanneDTO updatedHistoriquePanne = historiquePanneService.updateHistoriquePanne(id, historiquePanneDTO);
        return ResponseEntity.ok(updatedHistoriquePanne);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistoriquePanne(@PathVariable Long id) {
        historiquePanneService.deleteHistoriquePanne(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoriquePanneDTO> getHistoriquePanneById(@PathVariable Long id) {
        HistoriquePanneDTO historiquePanneDTO = historiquePanneService.getHistoriquePanneById(id);
        return ResponseEntity.ok(historiquePanneDTO);
    }

    @GetMapping
    public ResponseEntity<List<HistoriquePanneDTO>> getAllHistoriquePannes() {
        List<HistoriquePanneDTO> historiquePannes = historiquePanneService.getAllHistoriquePannes();
        return ResponseEntity.ok(historiquePannes);
    }
}
