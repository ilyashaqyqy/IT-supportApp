package com.ITsupport.support.App.service.impl;

import com.ITsupport.support.App.dto.EquipementDTO;
import com.ITsupport.support.App.mapper.EquipementMapper;
import com.ITsupport.support.App.model.Equipement;
import com.ITsupport.support.App.repository.EquipementRepository;
import com.ITsupport.support.App.service.EquipementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EquipementServiceImpl implements EquipementService {

    private final EquipementRepository equipementRepository;
    private final EquipementMapper equipementMapper;

    @Override
    public EquipementDTO createEquipement(EquipementDTO equipementDTO) {
        Equipement equipement = equipementMapper.toEntity(equipementDTO);
        Equipement savedEquipement = equipementRepository.save(equipement);
        return equipementMapper.toDTO(savedEquipement);
    }

    @Override
    public EquipementDTO updateEquipement(Long id, EquipementDTO equipementDTO) {
        Equipement equipement = equipementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Equipement not found"));
        equipementMapper.toEntity(equipementDTO);
        Equipement updatedEquipement = equipementRepository.save(equipement);
        return equipementMapper.toDTO(updatedEquipement);
    }

    @Override
    public void deleteEquipement(Long id) {
        equipementRepository.deleteById(id);
    }

    @Override
    public EquipementDTO getEquipementById(Long id) {
        Equipement equipement = equipementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Equipement not found"));
        return equipementMapper.toDTO(equipement);
    }

    @Override
    public List<EquipementDTO> getAllEquipements() {
        return equipementRepository.findAll().stream()
                .map(equipementMapper::toDTO)
                .collect(Collectors.toList());
    }
}
