package com.ITsupport.support.App.service.impl;

import com.ITsupport.support.App.dto.PanneDTO;
import com.ITsupport.support.App.mapper.PanneMapper;
import com.ITsupport.support.App.model.Panne;
import com.ITsupport.support.App.repository.PanneRepository;
import com.ITsupport.support.App.service.impl.PanneServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class PanneServiceImplTest {

    @Mock
    private PanneRepository panneRepository;

    @Mock
    private PanneMapper panneMapper;

    @InjectMocks
    private PanneServiceImpl panneService;

    private Panne panne;
    private PanneDTO panneDTO;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        panne = new Panne();
        panne.setId(1L);
        panne.setDescription("Test issue");
//        panne.setReportDate("2024-08-10");
//        panne.setRepairDate("2024-08-15");
        panne.setStatus("OPEN");

        panneDTO = new PanneDTO();
        panneDTO.setId(1L);
        panneDTO.setDescription("Test issue");
//        panneDTO.setReportDate("2024-08-10");
//        panneDTO.setRepairDate("2024-08-15");
        panneDTO.setStatus("OPEN");
    }

    @Test
    public void testCreatePanne() {
        when(panneMapper.toEntity(any(PanneDTO.class))).thenReturn(panne);
        when(panneRepository.save(any(Panne.class))).thenReturn(panne);
        when(panneMapper.toDTO(any(Panne.class))).thenReturn(panneDTO);

        PanneDTO createdPanne = panneService.createPanne(panneDTO);

        assertNotNull(createdPanne);
        assertEquals("Test issue", createdPanne.getDescription());

        verify(panneMapper, times(1)).toEntity(any(PanneDTO.class));
        verify(panneRepository, times(1)).save(any(Panne.class));
        verify(panneMapper, times(1)).toDTO(any(Panne.class));
    }

    @Test
    public void testUpdatePanne() {
        when(panneRepository.findById(1L)).thenReturn(Optional.of(panne));
        when(panneRepository.save(any(Panne.class))).thenReturn(panne);
        when(panneMapper.toDTO(any(Panne.class))).thenReturn(panneDTO);

        PanneDTO updatedPanne = panneService.updatePanne(1L, panneDTO);

        assertNotNull(updatedPanne);
        assertEquals("Test issue", updatedPanne.getDescription());

        verify(panneRepository, times(1)).findById(1L);
        verify(panneRepository, times(1)).save(any(Panne.class));
        verify(panneMapper, times(1)).toDTO(any(Panne.class));
    }

    @Test
    public void testUpdatePanne_NotFound() {
        when(panneRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> panneService.updatePanne(1L, panneDTO));

        verify(panneRepository, times(1)).findById(1L);
        verify(panneRepository, never()).save(any(Panne.class));
        verify(panneMapper, never()).toDTO(any(Panne.class));
    }

    @Test
    public void testDeletePanne() {
        doNothing().when(panneRepository).deleteById(1L);

        panneService.deletePanne(1L);

        verify(panneRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeletePanne_NotFound() {
        doThrow(new RuntimeException("Panne not found")).when(panneRepository).deleteById(1L);

        assertThrows(RuntimeException.class, () -> panneService.deletePanne(1L));

        verify(panneRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testGetPanneById() {
        when(panneRepository.findById(1L)).thenReturn(Optional.of(panne));
        when(panneMapper.toDTO(any(Panne.class))).thenReturn(panneDTO);

        PanneDTO foundPanne = panneService.getPanneById(1L);

        assertNotNull(foundPanne);
        assertEquals("Test issue", foundPanne.getDescription());

        verify(panneRepository, times(1)).findById(1L);
        verify(panneMapper, times(1)).toDTO(any(Panne.class));
    }

    @Test
    public void testGetPanneById_NotFound() {
        when(panneRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> panneService.getPanneById(1L));

        verify(panneRepository, times(1)).findById(1L);
        verify(panneMapper, never()).toDTO(any(Panne.class));
    }

    @Test
    public void testGetAllPannes() {
        when(panneRepository.findAll()).thenReturn(List.of(panne));
        when(panneMapper.toDTO(any(Panne.class))).thenReturn(panneDTO);

        List<PanneDTO> panneDTOList = panneService.getAllPannes();

        assertNotNull(panneDTOList);
        assertEquals(1, panneDTOList.size());
        assertEquals("Test issue", panneDTOList.get(0).getDescription());

        verify(panneRepository, times(1)).findAll();
        verify(panneMapper, times(1)).toDTO(any(Panne.class));
    }
}
