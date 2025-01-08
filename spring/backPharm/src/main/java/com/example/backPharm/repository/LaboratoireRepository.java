package com.example.backPharm.repository;

import com.example.backPharm.model.Laboratoire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoireRepository extends JpaRepository<Laboratoire, Integer> {
    // Ajoute des méthodes de recherche personnalisées ici si nécessaire
}
