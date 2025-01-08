package com.example.backPharm.repository;

import com.example.backPharm.model.Poste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosteRepository extends JpaRepository<Poste, Integer> {
    // Les méthodes basiques comme findAll, findById sont disponibles grâce à JpaRepository.
}
