package com.example.backPharm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.backPharm.model.TypeMedicament;

@Repository
public interface TypeMedicamentRepository extends JpaRepository<TypeMedicament, Integer> {
}
