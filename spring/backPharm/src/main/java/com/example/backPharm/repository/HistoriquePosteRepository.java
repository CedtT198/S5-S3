package com.example.backPharm.repository;

import com.example.backPharm.model.HistoriquePoste;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriquePosteRepository extends JpaRepository<HistoriquePoste, Integer> {
    List<HistoriquePoste> findByPersonnelIdPersonnel(Integer idPerso); 
    @Query("SELECT h FROM HistoriquePoste h " +
           "WHERE h.personnel.id = :idPersonnel " +
           "ORDER BY h.date_debut DESC LIMIT 1")
    HistoriquePoste findLatestPosteByPersonnel(@Param("idPersonnel") Integer idPersonnel);
}

