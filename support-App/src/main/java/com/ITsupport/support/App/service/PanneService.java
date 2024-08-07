package com.ITsupport.support.App.service;

import com.ITsupport.support.App.dto.PanneDTO;
import java.util.List;

public interface PanneService {
    PanneDTO createPanne(PanneDTO panneDTO);
    PanneDTO updatePanne(Long id, PanneDTO panneDTO);
    void deletePanne(Long id);
    PanneDTO getPanneById(Long id);
    List<PanneDTO> getAllPannes();
}
