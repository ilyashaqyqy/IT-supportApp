package com.ITsupport.support.App.service;

import com.ITsupport.support.App.dto.AdminDTO;
import java.util.List;

public interface AdminService {
    AdminDTO createAdmin(AdminDTO adminDTO);
    AdminDTO updateAdmin(Long id, AdminDTO adminDTO);
    void deleteAdmin(Long id);
    AdminDTO getAdminById(Long id);
    List<AdminDTO> getAllAdmins();
}
