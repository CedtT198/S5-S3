package com.example.backPharm.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.backPharm.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}
