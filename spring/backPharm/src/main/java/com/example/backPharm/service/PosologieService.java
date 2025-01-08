package com.example.backPharm.service;

import com.example.backPharm.model.Posologie;
import com.example.backPharm.repository.PosologieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PosologieService {

    @Autowired
    private PosologieRepository posologieRepository;

    // Méthode pour récupérer toutes les posologies
    public List<Posologie> getAllPosologies() {
        return posologieRepository.findAll();
    }

    // Méthode pour récupérer une posologie par son id
    public Optional<Posologie> getPosologieById(Integer id) {
        return posologieRepository.findById(id);
    }

    // Méthode pour ajouter une nouvelle posologie
    public Posologie addPosologie(Posologie posologie) {
        return posologieRepository.save(posologie);
    }

    // Méthode pour mettre à jour une posologie existante
    public Posologie updatePosologie(Posologie posologie) {
        return posologieRepository.save(posologie);
    }

    // Méthode pour supprimer une posologie par son id
    public void deletePosologie(Integer id) {
        posologieRepository.deleteById(id);
    }
}
