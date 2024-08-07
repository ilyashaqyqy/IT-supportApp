package com.ITsupport.support.App.service.impl;

import com.ITsupport.support.App.dto.UtilisateurDTO;
import com.ITsupport.support.App.mapper.UtilisateurMapper;
import com.ITsupport.support.App.model.Utilisateur;
import com.ITsupport.support.App.repository.UtilisateurRepository;
import com.ITsupport.support.App.service.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    @Override
    public UtilisateurDTO createUtilisateur(UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurMapper.toEntity(utilisateurDTO);
        Utilisateur savedUtilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.toDTO(savedUtilisateur);
    }

    @Override
    public UtilisateurDTO updateUtilisateur(Long id, UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur not found"));
        utilisateurMapper.toEntity(utilisateurDTO);
        Utilisateur updatedUtilisateur = utilisateurRepository.save(utilisateur);
        return utilisateurMapper.toDTO(updatedUtilisateur);
    }

    @Override
    public void deleteUtilisateur(Long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public UtilisateurDTO getUtilisateurById(Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Utilisateur not found"));
        return utilisateurMapper.toDTO(utilisateur);
    }

    @Override
    public List<UtilisateurDTO> getAllUtilisateurs() {
        return utilisateurRepository.findAll().stream()
                .map(utilisateurMapper::toDTO)
                .collect(Collectors.toList());
    }
}
