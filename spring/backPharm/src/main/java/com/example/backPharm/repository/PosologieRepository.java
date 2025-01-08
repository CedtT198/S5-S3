package com.example.backPharm.repository;

import com.example.backPharm.model.Posologie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosologieRepository extends JpaRepository<Posologie, Integer> {
    // Méthodes personnalisées peuvent être ajoutées ici
}
