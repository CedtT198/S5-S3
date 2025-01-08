package com.example.backPharm.repository;

import com.example.backPharm.model.Personnel;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Integer> {
    public List<Personnel> findAllByOrderByNomAsc();
    public List<Personnel> findAllByOrderByNomDesc();
}
