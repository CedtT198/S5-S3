package com.example.backPharm.repository;

import com.example.backPharm.model.PrixMed;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PrixMedRepository extends JpaRepository<PrixMed, Integer> {
    List<PrixMed> findByMedicamentIdMed(Integer idMed);
    @Query("SELECT p FROM PrixMed p WHERE p.medicament.id = :idMed ORDER BY p.datePrix DESC LIMIT 1")
    PrixMed findLatestPrixByMedicament(@Param("idMed") Integer idMed);
}
