package com.example.backPharm.repository;

import com.example.backPharm.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    // Méthodes personnalisées peuvent être ajoutées ici
}
