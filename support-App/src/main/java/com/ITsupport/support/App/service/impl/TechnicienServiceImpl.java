package com.ITsupport.support.App.service.impl;

import com.ITsupport.support.App.dto.TechnicienDTO;
import com.ITsupport.support.App.mapper.TechnicienMapper;
import com.ITsupport.support.App.model.Technicien;
import com.ITsupport.support.App.repository.TechnicienRepository;
import com.ITsupport.support.App.service.TechnicienService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TechnicienServiceImpl implements TechnicienService {

    private final TechnicienRepository technicienRepository;
    private final TechnicienMapper technicienMapper;

    @Override
    public TechnicienDTO createTechnicien(TechnicienDTO technicienDTO) {
        Technicien technicien = technicienMapper.toEntity(technicienDTO);
        Technicien savedTechnicien = technicienRepository.save(technicien);
        return technicienMapper.toDTO(savedTechnicien);
    }

    @Override
    public TechnicienDTO updateTechnicien(Long id, TechnicienDTO technicienDTO) {
        Technicien technicien = technicienRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Technicien not found"));
        technicien.setUsername(technicienDTO.getUsername());
        technicien.setSpecialisation(technicienDTO.getSpecialisation());
        technicien.setEmail(technicienDTO.getEmail());
        technicien.setPassword(technicienDTO.getPassword());

        Technicien updatedTechnicien = technicienRepository.save(technicien);
        return technicienMapper.toDTO(updatedTechnicien);
    }
    @Override
    public void deleteTechnicien(Long id) {
        technicienRepository.deleteById(id);
    }

    @Override
    public TechnicienDTO getTechnicienById(Long id) {
        Technicien technicien = technicienRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Technicien not found"));
        return technicienMapper.toDTO(technicien);
    }

    @Override
    public List<TechnicienDTO> getAllTechniciens() {
        return technicienRepository.findAll().stream()
                .map(technicienMapper::toDTO)
                .collect(Collectors.toList());
    }
}
