package com.ITsupport.support.App.repository;

import com.ITsupport.support.App.model.Panne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanneRepository extends JpaRepository<Panne, Long> {
}
