package com.ITsupport.support.App.service;

import com.ITsupport.support.App.dto.UtilisateurDTO;
import java.util.List;

public interface UtilisateurService {
    UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO);
    UtilisateurDTO updateUtilisateur(Long id, UtilisateurDTO utilisateurDTO);
    void deleteUtilisateur(Long id);
    UtilisateurDTO getUtilisateurById(Long id);
    List<UtilisateurDTO> getAllUtilisateurs();
}
