package com.example.backPharm.service;

import com.example.backPharm.model.PrixMed;
import com.example.backPharm.repository.PrixMedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrixMedService {

    @Autowired
    private PrixMedRepository prixMedRepository;

    // public List<PrixMed> findAllByOrderDatePrixDesc() {
    //     return prixMedRepository.findAllByOrderDatePrixDesc();
    // }

    public PrixMed getLatestPrixForMedicament(Integer idMed) {
        return prixMedRepository.findLatestPrixByMedicament(idMed);
    }

    public List<PrixMed> findByMedicamentId(Integer id) {
        return prixMedRepository.findByMedicamentIdMed(id);
    }

    // Trouver tous les prix des médicaments
    public List<PrixMed> findAll() {
        return prixMedRepository.findAll();
    }

    // Trouver un prix de médicament par son ID
    public Optional<PrixMed> findById(Integer id) {
        return prixMedRepository.findById(id);
    }

    // Sauvegarder un nouveau prix de médicament
    public PrixMed save(PrixMed prixMed) {
        return prixMedRepository.save(prixMed);
    }

    // Supprimer un prix de médicament
    public void delete(Integer id) {
        prixMedRepository.deleteById(id);
    }

    // Mettre à jour un prix de médicament
    public PrixMed update(Integer id, PrixMed prixMed) {
        if (prixMedRepository.existsById(id)) {
            prixMed.setIdPrixMed(id);  // Assurez-vous que l'ID est celui à mettre à jour.
            return prixMedRepository.save(prixMed);
        }
        return null; // ou une exception personnalisée si le prix de médicament n'existe pas
    }
}
