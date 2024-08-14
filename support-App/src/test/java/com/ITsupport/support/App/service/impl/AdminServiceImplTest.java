//package com.ITsupport.support.App.service.impl;
//
//import com.ITsupport.support.App.dto.AdminDTO;
//import com.ITsupport.support.App.mapper.AdminMapper;
//import com.ITsupport.support.App.model.Admin;
//import com.ITsupport.support.App.model.Role;
//import com.ITsupport.support.App.repository.AdminRepository;
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
//public class AdminServiceImplTest {
//
//    @Mock
//    private AdminRepository adminRepository;
//
//    @Mock
//    private AdminMapper adminMapper;
//
//    @InjectMocks
//    private AdminServiceImpl adminService;
//
//    private Admin admin;
//    private AdminDTO adminDTO;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//
//        admin = new Admin();
//        admin.setId(1L);
//        admin.setUsername("adminUser");
//        admin.setPassword("adminPass");
//        admin.setEmail("admin@example.com");
//        admin.setRole(Role.ROLE_ADMIN);
//
//        adminDTO = new AdminDTO();
//        adminDTO.setId(1L);
//        adminDTO.setUsername("adminUser");
//        adminDTO.setPassword("adminPass");
//        adminDTO.setEmail("admin@example.com");
//        adminDTO.setRole("ADMIN");
//    }
//
//    @Test
//    public void testCreateAdmin() {
//        when(adminMapper.toEntity(any(AdminDTO.class))).thenReturn(admin);
//        when(adminRepository.save(any(Admin.class))).thenReturn(admin);
//        when(adminMapper.toDTO(any(Admin.class))).thenReturn(adminDTO);
//
//        AdminDTO createdAdmin = adminService.createAdmin(adminDTO);
//
//        assertNotNull(createdAdmin);
//        assertEquals("adminUser", createdAdmin.getUsername());
//
//        verify(adminMapper, times(1)).toEntity(any(AdminDTO.class));
//        verify(adminRepository, times(1)).save(any(Admin.class));
//        verify(adminMapper, times(1)).toDTO(any(Admin.class));
//    }
//
//    @Test
//    public void testUpdateAdmin() {
//        when(adminRepository.findById(1L)).thenReturn(Optional.of(admin));
//        when(adminRepository.save(any(Admin.class))).thenReturn(admin);
//        when(adminMapper.toDTO(any(Admin.class))).thenReturn(adminDTO);
//
//        AdminDTO updatedAdmin = adminService.updateAdmin(1L, adminDTO);
//
//        assertNotNull(updatedAdmin);
//        assertEquals("adminUser", updatedAdmin.getUsername());
//
//        verify(adminRepository, times(1)).findById(1L);
//        verify(adminRepository, times(1)).save(any(Admin.class));
//        verify(adminMapper, times(1)).toDTO(any(Admin.class));
//    }
//
//    @Test
//    public void testDeleteAdmin() {
//        doNothing().when(adminRepository).deleteById(1L);
//
//        adminService.deleteAdmin(1L);
//
//        verify(adminRepository, times(1)).deleteById(1L);
//    }
//
//    @Test
//    public void testGetAdminById() {
//        when(adminRepository.findById(1L)).thenReturn(Optional.of(admin));
//        when(adminMapper.toDTO(any(Admin.class))).thenReturn(adminDTO);
//
//        AdminDTO foundAdmin = adminService.getAdminById(1L);
//
//        assertNotNull(foundAdmin);
//        assertEquals("adminUser", foundAdmin.getUsername());
//
//        verify(adminRepository, times(1)).findById(1L);
//        verify(adminMapper, times(1)).toDTO(any(Admin.class));
//    }
//
//    @Test
//    public void testGetAllAdmins() {
//        when(adminRepository.findAll()).thenReturn(List.of(admin));
//        when(adminMapper.toDTO(any(Admin.class))).thenReturn(adminDTO);
//
//        List<AdminDTO> adminDTOList = adminService.getAllAdmins();
//
//        assertNotNull(adminDTOList);
//        assertEquals(1, adminDTOList.size());
//        assertEquals("adminUser", adminDTOList.get(0).getUsername());
//
//        verify(adminRepository, times(1)).findAll();
//        verify(adminMapper, times(1)).toDTO(any(Admin.class));
//    }
//}
