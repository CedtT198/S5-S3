package com.example.backPharm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.backPharm.model.Conseil;
import com.example.backPharm.model.Medicaments;

@Repository
public interface ConseilRepository extends JpaRepository<Conseil, Integer> {
    
    @Query("SELECT c FROM Conseil c WHERE EXTRACT(MONTH FROM c.dateConseil) = :month AND EXTRACT(YEAR FROM c.dateConseil) = :year")
    List<Conseil> findAllByDateConseil(@Param("month") Integer mois, @Param("year") Integer annee);
}
