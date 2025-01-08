package com.example.backPharm.repository;

import com.example.backPharm.model.Maladie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaladieRepository extends JpaRepository<Maladie, Integer> {
    // Les méthodes basiques comme findAll, findById sont disponibles grâce à JpaRepository.
}
