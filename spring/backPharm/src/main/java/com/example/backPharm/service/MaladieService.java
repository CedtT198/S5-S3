package com.example.backPharm.service;

import com.example.backPharm.model.Maladie;
import com.example.backPharm.repository.MaladieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaladieService {

    @Autowired
    private MaladieRepository maladieRepository;

    // Trouver tous les postes
    public List<Maladie> findAll() {
        return maladieRepository.findAll();
    }

    // Trouver un poste par son ID
    public Optional<Maladie> findById(Integer id) {
        return maladieRepository.findById(id);
    }

    // Sauvegarder un nouveau poste
    public Maladie save(Maladie poste) {
        return maladieRepository.save(poste);
    }

    // Supprimer un poste
    public void delete(Integer id) {
        maladieRepository.deleteById(id);
    }

    // Mettre à jour un poste
    public Maladie update(Integer id, Maladie mal) {
        if (maladieRepository.existsById(id)) {
            mal.setId_Maladie(id);  // Assurez-vous que l'ID est celui à mettre à jour.
            return maladieRepository.save(mal);
        }
        return null; // ou une exception personnalisée si le poste n'existe pas
    }
}
