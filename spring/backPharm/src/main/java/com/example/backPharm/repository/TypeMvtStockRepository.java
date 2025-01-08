package com.example.backPharm.repository;

import com.example.backPharm.model.TypeMvtStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeMvtStockRepository extends JpaRepository<TypeMvtStock, Integer> {
    // Les méthodes basiques sont déjà disponibles grâce à JpaRepository.
}

