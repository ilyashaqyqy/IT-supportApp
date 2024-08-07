package com.ITsupport.support.App.repository;

import com.ITsupport.support.App.model.HistoriquePanne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriquePanneRepository extends JpaRepository<HistoriquePanne, Long> {
}
