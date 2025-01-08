package com.example.backPharm.repository;

import com.example.backPharm.model.Forme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormeRepository extends JpaRepository<Forme, Integer> {
    // Les méthodes basiques comme findAll, findById sont disponibles grâce à JpaRepository.
}
