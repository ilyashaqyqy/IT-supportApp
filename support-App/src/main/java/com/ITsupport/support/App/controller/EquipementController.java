package com.ITsupport.support.App.controller;

import com.ITsupport.support.App.dto.EquipementDTO;
import com.ITsupport.support.App.service.EquipementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final EquipementService equipementService;

    @PostMapping
    public ResponseEntity<EquipementDTO> createEquipement(@RequestBody EquipementDTO equipementDTO) {
        EquipementDTO createdEquipement = equipementService.createEquipement(equipementDTO);
        return ResponseEntity.ok(createdEquipement);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EquipementDTO> updateEquipement(@PathVariable Long id, @RequestBody EquipementDTO equipementDTO) {
        EquipementDTO updatedEquipement = equipementService.updateEquipement(id, equipementDTO);
        return ResponseEntity.ok(updatedEquipement);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEquipement(@PathVariable Long id) {
        equipementService.deleteEquipement(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipementDTO> getEquipementById(@PathVariable Long id) {
        EquipementDTO equipementDTO = equipementService.getEquipementById(id);
        return ResponseEntity.ok(equipementDTO);
    }

    @GetMapping
    public ResponseEntity<List<EquipementDTO>> getAllEquipements() {
        List<EquipementDTO> equipements = equipementService.getAllEquipements();
        return ResponseEntity.ok(equipements);
    }
}
