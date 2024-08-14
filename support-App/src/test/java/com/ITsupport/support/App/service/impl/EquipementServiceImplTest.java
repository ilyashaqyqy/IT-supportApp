//package com.ITsupport.support.App.service.impl;
//
//import com.ITsupport.support.App.dto.EquipementDTO;
//import com.ITsupport.support.App.mapper.EquipementMapper;
//import com.ITsupport.support.App.model.Equipement;
//import com.ITsupport.support.App.repository.EquipementRepository;
//import com.ITsupport.support.App.service.impl.EquipementServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.*;
//
//public class EquipementServiceImplTest {
//
//    @Mock
//    private EquipementRepository equipementRepository;
//
//    @Mock
//    private EquipementMapper equipementMapper;
//
//    @InjectMocks
//    private EquipementServiceImpl equipementService;
//
//    private Equipement equipement;
//    private EquipementDTO equipementDTO;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        equipement = new Equipement();
//        equipement.setId(1L);
//        equipement.setName("Laptop");
//        equipement.setDescription("Dell XPS 13");
//        equipement.setLocation("Office");
//        equipement.setStatus("Available");
//
//        equipementDTO = new EquipementDTO();
//        equipementDTO.setId(1L);
//        equipementDTO.setName("Laptop");
//        equipementDTO.setDescription("Dell XPS 13");
//        equipementDTO.setLocation("Office");
//        equipementDTO.setStatus("Available");
//    }
//
//    @Test
//    public void testCreateEquipement() {
//        when(equipementMapper.toEntity(any(EquipementDTO.class))).thenReturn(equipement);
//        when(equipementRepository.save(any(Equipement.class))).thenReturn(equipement);
//        when(equipementMapper.toDTO(any(Equipement.class))).thenReturn(equipementDTO);
//
//        EquipementDTO createdEquipement = equipementService.createEquipement(equipementDTO);
//
//        assertNotNull(createdEquipement);
//        assertEquals("Laptop", createdEquipement.getName());
//
//        verify(equipementMapper, times(1)).toEntity(any(EquipementDTO.class));
//        verify(equipementRepository, times(1)).save(any(Equipement.class));
//        verify(equipementMapper, times(1)).toDTO(any(Equipement.class));
//    }
//
//    @Test
//    public void testUpdateEquipement() {
//        when(equipementRepository.findById(1L)).thenReturn(Optional.of(equipement));
//        when(equipementRepository.save(any(Equipement.class))).thenReturn(equipement);
//        when(equipementMapper.toDTO(any(Equipement.class))).thenReturn(equipementDTO);
//
//        EquipementDTO updatedEquipement = equipementService.updateEquipement(1L, equipementDTO);
//
//        assertNotNull(updatedEquipement);
//        assertEquals("Laptop", updatedEquipement.getName());
//
//        verify(equipementRepository, times(1)).findById(1L);
//        verify(equipementRepository, times(1)).save(any(Equipement.class));
//        verify(equipementMapper, times(1)).toDTO(any(Equipement.class));
//    }
//
//    @Test
//    public void testUpdateEquipement_NotFound() {
//        when(equipementRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(IllegalArgumentException.class, () -> equipementService.updateEquipement(1L, equipementDTO));
//
//        verify(equipementRepository, times(1)).findById(1L);
//        verify(equipementRepository, never()).save(any(Equipement.class));
//        verify(equipementMapper, never()).toDTO(any(Equipement.class));
//    }
//
//    @Test
//    public void testDeleteEquipement() {
//        doNothing().when(equipementRepository).deleteById(1L);
//
//        equipementService.deleteEquipement(1L);
//
//        verify(equipementRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    public void testDeleteEquipement_NotFound() {
//        doThrow(new RuntimeException("Equipement not found")).when(equipementRepository).deleteById(1L);
//
//        assertThrows(RuntimeException.class, () -> equipementService.deleteEquipement(1L));
//
//        verify(equipementRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    public void testGetEquipementById() {
//        when(equipementRepository.findById(1L)).thenReturn(Optional.of(equipement));
//        when(equipementMapper.toDTO(any(Equipement.class))).thenReturn(equipementDTO);
//
//        EquipementDTO foundEquipement = equipementService.getEquipementById(1L);
//
//        assertNotNull(foundEquipement);
//        assertEquals("Laptop", foundEquipement.getName());
//
//        verify(equipementRepository, times(1)).findById(1L);
//        verify(equipementMapper, times(1)).toDTO(any(Equipement.class));
//    }
//
//    @Test
//    public void testGetEquipementById_NotFound() {
//        when(equipementRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(IllegalArgumentException.class, () -> equipementService.getEquipementById(1L));
//
//        verify(equipementRepository, times(1)).findById(1L);
//        verify(equipementMapper, never()).toDTO(any(Equipement.class));
//    }
//
//    @Test
//    public void testGetAllEquipements() {
//        when(equipementRepository.findAll()).thenReturn(List.of(equipement));
//        when(equipementMapper.toDTO(any(Equipement.class))).thenReturn(equipementDTO);
//
//        List<EquipementDTO> equipementDTOList = equipementService.getAllEquipements();
//
//        assertNotNull(equipementDTOList);
//        assertEquals(1, equipementDTOList.size());
//        assertEquals("Laptop", equipementDTOList.get(0).getName());
//
//        verify(equipementRepository, times(1)).findAll();
//        verify(equipementMapper, times(1)).toDTO(any(Equipement.class));
//    }
//}
