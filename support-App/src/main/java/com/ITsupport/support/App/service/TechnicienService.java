package com.ITsupport.support.App.service;

import com.ITsupport.support.App.dto.TechnicienDTO;
import java.util.List;

public interface TechnicienService {
    TechnicienDTO createTechnicien(TechnicienDTO technicienDTO);
    TechnicienDTO updateTechnicien(Long id, TechnicienDTO technicienDTO);
    void deleteTechnicien(Long id);
    TechnicienDTO getTechnicienById(Long id);
    List<TechnicienDTO> getAllTechniciens();
}
