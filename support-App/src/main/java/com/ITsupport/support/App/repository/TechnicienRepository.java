package com.ITsupport.support.App.repository;

import com.ITsupport.support.App.model.Technicien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicienRepository extends JpaRepository<Technicien, Long> {
}
