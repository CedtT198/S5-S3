package com.example.backPharm.service;

import com.example.backPharm.model.HistoriquePoste;
import com.example.backPharm.repository.HistoriquePosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HistoriquePosteService {

    @Autowired
    private HistoriquePosteRepository historique_posteRepository;

    // Trouver tous les historiques de postes
    public HistoriquePoste findLatestPosteByPersonnel(Integer idPerso) {
        return historique_posteRepository.findLatestPosteByPersonnel(idPerso);
    }

    public List<HistoriquePoste> findByPersonnelId(Integer idPerso) {
        return historique_posteRepository.findByPersonnelIdPersonnel(idPerso);
    }

    public List<HistoriquePoste> findAll() {
        return historique_posteRepository.findAll();
    }

    // Trouver un historique de poste par son ID
    public Optional<HistoriquePoste> findById(Integer id) {
        return historique_posteRepository.findById(id);
    }

    // Sauvegarder un nouvel historique de poste
    public HistoriquePoste save(HistoriquePoste historique_poste) {
        return historique_posteRepository.save(historique_poste);
    }

    // Supprimer un historique de poste
    public void delete(Integer id) {
        historique_posteRepository.deleteById(id);
    }

    // Mettre à jour un historique de poste
    public HistoriquePoste update(Integer id, HistoriquePoste historique_poste) {
        if (historique_posteRepository.existsById(id)) {
            historique_poste.setid_historique_poste(id);  // Assurez-vous que l'ID est celui à mettre à jour.
            return historique_posteRepository.save(historique_poste);
        }
        return null; // ou une exception personnalisée si l'historique de poste n'existe pas
    }
}

