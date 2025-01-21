package com.example.backPharm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backPharm.model.Conseil;
import com.example.backPharm.model.Medicaments;
import com.example.backPharm.repository.ConseilRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ConseilService {

    @Autowired
    private ConseilRepository conseilRepository;

    // Ajouter un nouveau conseil
    public Conseil save(Conseil conseil) {
        return conseilRepository.save(conseil);
    }

    // Obtenir tous les conseils
    public List<Conseil> findAll() {
        return conseilRepository.findAll();
    }

    public List<Conseil> findAllByDateConseil(int mois, int annee) {
        return conseilRepository.findAllByDateConseil(mois, annee);
    }

    // Trouver un conseil par ID
    public Optional<Conseil> findById(Integer id) {
        return conseilRepository.findById(id);
    }

    // Mettre à jour un conseil
    public Conseil update(Conseil conseil) {
        return conseilRepository.save(conseil);
    }

    // Supprimer un conseil
    public void delete(Integer id) {
        conseilRepository.deleteById(id);
    }
}
