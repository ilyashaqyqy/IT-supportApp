package com.ITsupport.support.App.service;

import com.ITsupport.support.App.dto.HistoriquePanneDTO;
import java.util.List;

public interface HistoriquePanneService {
    HistoriquePanneDTO createHistoriquePanne(HistoriquePanneDTO historiquePanneDTO);
    HistoriquePanneDTO updateHistoriquePanne(Long id, HistoriquePanneDTO historiquePanneDTO);
    void deleteHistoriquePanne(Long id);
    HistoriquePanneDTO getHistoriquePanneById(Long id);
    List<HistoriquePanneDTO> getAllHistoriquePannes();
}
