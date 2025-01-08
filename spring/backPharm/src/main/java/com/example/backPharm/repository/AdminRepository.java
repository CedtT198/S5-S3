package com.example.backPharm.repository;

import com.example.backPharm.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    // Les méthodes basiques comme findAll, findById sont disponibles grâce à JpaRepository.
}

