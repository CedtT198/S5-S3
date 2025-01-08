package com.example.backPharm.service;

import com.example.backPharm.model.Poste;
import com.example.backPharm.repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PosteService {

    @Autowired
    private PosteRepository posteRepository;

    // Trouver tous les postes
    public List<Poste> findAll() {
        return posteRepository.findAll();
    }

    // Trouver un poste par son ID
    public Optional<Poste> findById(Integer id) {
        return posteRepository.findById(id);
    }

    // Sauvegarder un nouveau poste
    public Poste save(Poste poste) {
        return posteRepository.save(poste);
    }

    // Supprimer un poste
    public void delete(Integer id) {
        posteRepository.deleteById(id);
    }

    // Mettre à jour un poste
    public Poste update(Integer id, Poste poste) {
        if (posteRepository.existsById(id)) {
            poste.setid_poste(id);  // Assurez-vous que l'ID est celui à mettre à jour.
            return posteRepository.save(poste);
        }
        return null; // ou une exception personnalisée si le poste n'existe pas
    }
}
