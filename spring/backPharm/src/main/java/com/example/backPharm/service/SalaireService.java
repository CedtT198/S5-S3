package com.example.backPharm.service;

import com.example.backPharm.model.Salaire;
import com.example.backPharm.repository.SalaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaireService {
 
    @Autowired
    private SalaireRepository salaireRepository;

    public Salaire findLatestSalaireByPersonnel(Integer idPerso) {
        return salaireRepository.findLatestSalaireByPersonnel(idPerso);
    }

    public List<Salaire> findByPersonnelId(Integer idPerso) {
        return salaireRepository.findByPersonnelIdPersonnel(idPerso);
    }

    // Trouver tous les salaires
    public List<Salaire> findAll() {
        return salaireRepository.findAll();
    }

    // Trouver un salaire par son ID
    public Optional<Salaire> findById(Integer id) {
        return salaireRepository.findById(id);
    }

    // Sauvegarder un nouveau salaire
    public Salaire save(Salaire salaire) {
        return salaireRepository.save(salaire);
    }

    // Supprimer un salaire
    public void delete(Integer id) {
        salaireRepository.deleteById(id);
    }

    // Mettre à jour un salaire
    public Salaire update(Integer id, Salaire salaire) {
        if (salaireRepository.existsById(id)) {
            salaire.setIdSalaire(id);  // Assurez-vous que l'ID est celui à mettre à jour.
            return salaireRepository.save(salaire);
        }
        return null; // ou une exception personnalisée si le salaire n'existe pas
    }
}
