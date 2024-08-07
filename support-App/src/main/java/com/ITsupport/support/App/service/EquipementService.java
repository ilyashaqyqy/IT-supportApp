package com.ITsupport.support.App.service;

import com.ITsupport.support.App.dto.EquipementDTO;
import java.util.List;

public interface EquipementService {
    EquipementDTO createEquipement(EquipementDTO equipementDTO);
    EquipementDTO updateEquipement(Long id, EquipementDTO equipementDTO);
    void deleteEquipement(Long id);
    EquipementDTO getEquipementById(Long id);
    List<EquipementDTO> getAllEquipements();
}
