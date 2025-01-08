package com.example.backPharm.repository;

import com.example.backPharm.model.MedicamentLabo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentLaboRepository extends JpaRepository<MedicamentLabo, Integer> {
    // Méthodes personnalisées peuvent être ajoutées ici
}
