package com.ITsupport.support.App.service.impl;

import com.ITsupport.support.App.dto.PanneDTO;
import com.ITsupport.support.App.mapper.PanneMapper;
import com.ITsupport.support.App.model.Equipement;
import com.ITsupport.support.App.model.Panne;
import com.ITsupport.support.App.repository.PanneRepository;
import com.ITsupport.support.App.service.PanneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PanneServiceImpl implements PanneService {

    private final PanneRepository panneRepository;
    private final PanneMapper panneMapper;

    @Override
    public PanneDTO createPanne(PanneDTO panneDTO) {
        Panne panne = panneMapper.toEntity(panneDTO);
        Panne savedPanne = panneRepository.save(panne);
        return panneMapper.toDTO(savedPanne);
    }

    @Override
    public PanneDTO updatePanne(Long id, PanneDTO panneDTO) {
        Panne panne = panneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Panne not found"));
        panne.setDescription(panneDTO.getDescription());
        panne.setReportDate(panneDTO.getReportDate());
        panne.setRepairDate(panneDTO.getRepairDate());
        panne.setStatus(panneDTO.getStatus());

        Panne updatedPanne = panneRepository.save(panne);
        return panneMapper.toDTO(updatedPanne);
    }

    @Override
    public void deletePanne(Long id) {
        panneRepository.deleteById(id);
    }

    @Override
    public PanneDTO getPanneById(Long id) {
        Panne panne = panneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Panne not found"));
        return panneMapper.toDTO(panne);
    }

    @Override
    public List<PanneDTO> getAllPannes() {
        return panneRepository.findAll().stream()
                .map(panneMapper::toDTO)
                .collect(Collectors.toList());
    }
}
