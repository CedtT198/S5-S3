package com.example.backPharm.service;

import com.example.backPharm.model.Forme;
import com.example.backPharm.repository.FormeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FormeService {

    @Autowired
    private FormeRepository formeRepository;

    // Trouver tous les postes
    public List<Forme> findAll() {
        return formeRepository.findAll();
    }

    // Trouver un poste par son ID
    public Optional<Forme> findById(Integer id) {
        return formeRepository.findById(id);
    }

    // Sauvegarder un nouveau poste
    public Forme save(Forme poste) {
        return formeRepository.save(poste);
    }

    // Supprimer un poste
    public void delete(Integer id) {
        formeRepository.deleteById(id);
    }

    // Mettre à jour un poste
    public Forme update(Integer id, Forme forme) {
        if (formeRepository.existsById(id)) {
            forme.setIdForme(id);  // Assurez-vous que l'ID est celui à mettre à jour.
            return formeRepository.save(forme);
        }
        return null; // ou une exception personnalisée si le poste n'existe pas
    }
}
