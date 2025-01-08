package com.example.backPharm.repository;

import com.example.backPharm.model.Salaire;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaireRepository extends JpaRepository<Salaire, Integer> {
    List<Salaire> findByPersonnelIdPersonnel(Integer idPerso); 
    
    @Query("SELECT s FROM Salaire s WHERE s.personnel.id = :idPersonnel ORDER BY s.dateSalaire DESC LIMIT 1")
    Salaire findLatestSalaireByPersonnel(@Param("idPersonnel") Integer idPersonnel);
}
