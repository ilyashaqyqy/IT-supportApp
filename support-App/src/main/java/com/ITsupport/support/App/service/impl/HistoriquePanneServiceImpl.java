package com.ITsupport.support.App.service.impl;

import com.ITsupport.support.App.dto.HistoriquePanneDTO;
import com.ITsupport.support.App.mapper.HistoriquePanneMapper;
import com.ITsupport.support.App.model.HistoriquePanne;
import com.ITsupport.support.App.repository.HistoriquePanneRepository;
import com.ITsupport.support.App.service.HistoriquePanneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class HistoriquePanneServiceImpl implements HistoriquePanneService {

    private final HistoriquePanneRepository historiquePanneRepository;
    private final HistoriquePanneMapper historiquePanneMapper;

    @Override
    public HistoriquePanneDTO createHistoriquePanne(HistoriquePanneDTO historiquePanneDTO) {
        HistoriquePanne historiquePanne = historiquePanneMapper.toEntity(historiquePanneDTO);
        HistoriquePanne savedHistoriquePanne = historiquePanneRepository.save(historiquePanne);
        return historiquePanneMapper.toDTO(savedHistoriquePanne);
    }

    @Override
    public HistoriquePanneDTO updateHistoriquePanne(Long id, HistoriquePanneDTO historiquePanneDTO) {
        HistoriquePanne historiquePanne = historiquePanneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("HistoriquePanne not found"));

        // Manually update fields
  
        historiquePanne.setRepairDate(historiquePanneDTO.getRepairDate());



        HistoriquePanne updatedHistoriquePanne = historiquePanneRepository.save(historiquePanne);
        return historiquePanneMapper.toDTO(updatedHistoriquePanne);
    }

    @Override
    public void deleteHistoriquePanne(Long id) {
        historiquePanneRepository.deleteById(id);
    }

    @Override
    public HistoriquePanneDTO getHistoriquePanneById(Long id) {
        HistoriquePanne historiquePanne = historiquePanneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("HistoriquePanne not found"));
        return historiquePanneMapper.toDTO(historiquePanne);
    }

    @Override
    public List<HistoriquePanneDTO> getAllHistoriquePannes() {
        return historiquePanneRepository.findAll().stream()
                .map(historiquePanneMapper::toDTO)
                .collect(Collectors.toList());
    }
}
