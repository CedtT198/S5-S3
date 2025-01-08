package com.example.backPharm.service;

import com.example.backPharm.model.Laboratoire;
import com.example.backPharm.repository.LaboratoireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoireService {

    @Autowired
    private LaboratoireRepository laboratoireRepository;

    // Méthode pour récupérer tous les laboratoires
    public List<Laboratoire> getAllLaboratoires() {
        return laboratoireRepository.findAll();
    }

    // Méthode pour récupérer un laboratoire par son id
    public Optional<Laboratoire> getLaboratoireById(Integer id) {
        return laboratoireRepository.findById(id);
    }

    // Méthode pour ajouter un nouveau laboratoire
    public Laboratoire addLaboratoire(Laboratoire laboratoire) {
        return laboratoireRepository.save(laboratoire);
    }

    // Méthode pour mettre à jour un laboratoire existant
    public Laboratoire updateLaboratoire(Laboratoire laboratoire) {
        return laboratoireRepository.save(laboratoire);
    }

    // Méthode pour supprimer un laboratoire par son id
    public void deleteLaboratoire(Integer id) {
        laboratoireRepository.deleteById(id);
    }
}
