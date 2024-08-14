//package com.ITsupport.support.App.service.impl;
//
//import com.ITsupport.support.App.dto.TicketSupportDTO;
//import com.ITsupport.support.App.mapper.TicketSupportMapper;
//import com.ITsupport.support.App.model.*;
//import com.ITsupport.support.App.repository.*;
//import com.ITsupport.support.App.service.impl.TicketSupportServiceImpl;
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
//public class TicketSupportServiceImplTest {
//
//    @Mock
//    private TicketSupportRepository ticketSupportRepository;
//
//    @Mock
//    private TicketSupportMapper ticketSupportMapper;
//
//    @Mock
//    private TechnicienRepository technicienRepository;
//
//    @Mock
//    private UtilisateurRepository utilisateurRepository;
//
//    @Mock
//    private EquipementRepository equipementRepository;
//
//    @Mock
//    private PanneRepository panneRepository;
//
//    @InjectMocks
//    private TicketSupportServiceImpl ticketSupportService;
//
//    private TicketSupport ticketSupport;
//    private TicketSupportDTO ticketSupportDTO;
//    private Utilisateur utilisateur;
//    private Equipement equipement;
//    private Panne panne;
//    private Technicien technicien;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        utilisateur = new Utilisateur();
//        utilisateur.setId(1L);
//
//        equipement = new Equipement();
//        equipement.setId(1L);
//
//        panne = new Panne();
//        panne.setId(1L);
//
//        technicien = new Technicien();
//        technicien.setId(1L);
//
//        ticketSupport = new TicketSupport();
//        ticketSupport.setId(1L);
//        ticketSupport.setDescription("Test issue");
//        ticketSupport.setEtat(TicketStatus.OPEN);
//        ticketSupport.setUtilisateur(utilisateur);
//        ticketSupport.setEquipment(equipement);
//        ticketSupport.setPanne(panne);
//        ticketSupport.setTechnicienAssigne(null);
//
//        ticketSupportDTO = new TicketSupportDTO();
//        ticketSupportDTO.setId(1L);
//        ticketSupportDTO.setDescription("Test issue");
//        ticketSupportDTO.setEtat("OPEN");
////        ticketSupportDTO.setDateCreation("2024-08-10");
//        ticketSupportDTO.setUtilisateurId(1L);
//        ticketSupportDTO.setEquipmentId(1L);
//        ticketSupportDTO.setPanneId(1L);
//        ticketSupportDTO.setTechnicienAssigneId(null);
//    }
//
//    @Test
//    public void testCreateTicketSupport() {
//        when(utilisateurRepository.findById(1L)).thenReturn(Optional.of(utilisateur));
//        when(equipementRepository.findById(1L)).thenReturn(Optional.of(equipement));
//        when(panneRepository.findById(1L)).thenReturn(Optional.of(panne));
//        when(ticketSupportMapper.toEntity(any(TicketSupportDTO.class))).thenReturn(ticketSupport);
//        when(ticketSupportRepository.save(any(TicketSupport.class))).thenReturn(ticketSupport);
//        when(ticketSupportMapper.toDTO(any(TicketSupport.class))).thenReturn(ticketSupportDTO);
//
//        TicketSupportDTO createdTicketSupport = ticketSupportService.createTicketSupport(ticketSupportDTO);
//
//        assertNotNull(createdTicketSupport);
//        assertEquals("Test issue", createdTicketSupport.getDescription());
//
//        verify(utilisateurRepository, times(1)).findById(1L);
//        verify(equipementRepository, times(1)).findById(1L);
//        verify(panneRepository, times(1)).findById(1L);
//        verify(ticketSupportMapper, times(1)).toEntity(any(TicketSupportDTO.class));
//        verify(ticketSupportRepository, times(1)).save(any(TicketSupport.class));
//        verify(ticketSupportMapper, times(1)).toDTO(any(TicketSupport.class));
//    }
//
//    @Test
//    public void testUpdateTicketSupport() {
//        when(ticketSupportRepository.findById(1L)).thenReturn(Optional.of(ticketSupport));
//        when(ticketSupportRepository.save(any(TicketSupport.class))).thenReturn(ticketSupport);
//        when(ticketSupportMapper.toDTO(any(TicketSupport.class))).thenReturn(ticketSupportDTO);
//
//        TicketSupportDTO updatedTicketSupport = ticketSupportService.updateTicketSupport(1L, ticketSupportDTO);
//
//        assertNotNull(updatedTicketSupport);
//        assertEquals("Test issue", updatedTicketSupport.getDescription());
//
//        verify(ticketSupportRepository, times(1)).findById(1L);
//        verify(ticketSupportRepository, times(1)).save(any(TicketSupport.class));
//        verify(ticketSupportMapper, times(1)).toDTO(any(TicketSupport.class));
//    }
//
//    @Test
//    public void testUpdateTicketSupport_NotFound() {
//        when(ticketSupportRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(IllegalArgumentException.class, () -> ticketSupportService.updateTicketSupport(1L, ticketSupportDTO));
//
//        verify(ticketSupportRepository, times(1)).findById(1L);
//        verify(ticketSupportRepository, never()).save(any(TicketSupport.class));
//        verify(ticketSupportMapper, never()).toDTO(any(TicketSupport.class));
//    }
//
//    @Test
//    public void testDeleteTicketSupport() {
//        doNothing().when(ticketSupportRepository).deleteById(1L);
//
//        ticketSupportService.deleteTicketSupport(1L);
//
//        verify(ticketSupportRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    public void testDeleteTicketSupport_NotFound() {
//        doThrow(new RuntimeException("TicketSupport not found")).when(ticketSupportRepository).deleteById(1L);
//
//        assertThrows(RuntimeException.class, () -> ticketSupportService.deleteTicketSupport(1L));
//
//        verify(ticketSupportRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    public void testGetTicketSupportById() {
//        when(ticketSupportRepository.findById(1L)).thenReturn(Optional.of(ticketSupport));
//        when(ticketSupportMapper.toDTO(any(TicketSupport.class))).thenReturn(ticketSupportDTO);
//
//        TicketSupportDTO foundTicketSupport = ticketSupportService.getTicketSupportById(1L);
//
//        assertNotNull(foundTicketSupport);
//        assertEquals("Test issue", foundTicketSupport.getDescription());
//
//        verify(ticketSupportRepository, times(1)).findById(1L);
//        verify(ticketSupportMapper, times(1)).toDTO(any(TicketSupport.class));
//    }
//
//    @Test
//    public void testGetTicketSupportById_NotFound() {
//        when(ticketSupportRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(IllegalArgumentException.class, () -> ticketSupportService.getTicketSupportById(1L));
//
//        verify(ticketSupportRepository, times(1)).findById(1L);
//        verify(ticketSupportMapper, never()).toDTO(any(TicketSupport.class));
//    }
//
//    @Test
//    public void testGetAllTicketSupports() {
//        when(ticketSupportRepository.findAll()).thenReturn(List.of(ticketSupport));
//        when(ticketSupportMapper.toDTO(any(TicketSupport.class))).thenReturn(ticketSupportDTO);
//
//        List<TicketSupportDTO> ticketSupportDTOList = ticketSupportService.getAllTicketSupports();
//
//        assertNotNull(ticketSupportDTOList);
//        assertEquals(1, ticketSupportDTOList.size());
//        assertEquals("Test issue", ticketSupportDTOList.get(0).getDescription());
//
//        verify(ticketSupportRepository, times(1)).findAll();
//        verify(ticketSupportMapper, times(1)).toDTO(any(TicketSupport.class));
//    }
//
//    @Test
//    public void testAssignTicketToTechnician() {
//        when(ticketSupportRepository.findById(1L)).thenReturn(Optional.of(ticketSupport));
//        when(technicienRepository.findById(1L)).thenReturn(Optional.of(technicien));
//        when(ticketSupportRepository.save(any(TicketSupport.class))).thenReturn(ticketSupport);
//
//        ticketSupportService.assignTicketToTechnician(1L, 1L);
//
//        assertEquals(technicien, ticketSupport.getTechnicienAssigne());
//        assertEquals(TicketStatus.ASSIGNED, ticketSupport.getEtat());
//
//        verify(ticketSupportRepository, times(1)).findById(1L);
//        verify(technicienRepository, times(1)).findById(1L);
//        verify(ticketSupportRepository, times(1)).save(any(TicketSupport.class));
//    }
//
//    @Test
//    public void testAssignTicketToTechnician_TicketNotFound() {
//        when(ticketSupportRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(IllegalArgumentException.class, () -> ticketSupportService.assignTicketToTechnician(1L, 1L));
//
//        verify(ticketSupportRepository, times(1)).findById(1L);
//        verify(technicienRepository, never()).findById(1L);
//        verify(ticketSupportRepository, never()).save(any(TicketSupport.class));
//    }
//
//    @Test
//    public void testAssignTicketToTechnician_TechnicianNotFound() {
//        when(ticketSupportRepository.findById(1L)).thenReturn(Optional.of(ticketSupport));
//        when(technicienRepository.findById(1L)).thenReturn(Optional.empty());
//
//        assertThrows(IllegalArgumentException.class, () -> ticketSupportService.assignTicketToTechnician(1L, 1L));
//
//        verify(ticketSupportRepository, times(1)).findById(1L);
//        verify(technicienRepository, times(1)).findById(1L);
//        verify(ticketSupportRepository, never()).save(any(TicketSupport.class));
//    }
//}
