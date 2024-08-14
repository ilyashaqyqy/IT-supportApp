package com.ITsupport.support.App.repository;

import com.ITsupport.support.App.model.TicketSupport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketSupportRepository extends JpaRepository<TicketSupport, Long> {
    List<TicketSupport> findByUtilisateurId(Long utilisateurId);
}
