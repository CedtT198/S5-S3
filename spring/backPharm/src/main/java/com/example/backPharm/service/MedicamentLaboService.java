package com.example.backPharm.service;

import com.example.backPharm.model.MedicamentLabo;
import com.example.backPharm.repository.MedicamentLaboRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentLaboService {

    @Autowired
    private MedicamentLaboRepository medicamentLaboRepository;

    // Méthode pour récupérer tous les medicament_labo
    public List<MedicamentLabo> getAllMedicamentLabo() {
        return medicamentLaboRepository.findAll();
    }

    // Méthode pour récupérer un medicament_labo par son id
    public Optional<MedicamentLabo> getMedicamentLaboById(Integer id) {
        return medicamentLaboRepository.findById(id);
    }

    // Méthode pour ajouter un nouveau medicament_labo
    public MedicamentLabo addMedicamentLabo(MedicamentLabo medicamentLabo) {
        return medicamentLaboRepository.save(medicamentLabo);
    }

    // Méthode pour mettre à jour un medicament_labo existant
    public MedicamentLabo updateMedicamentLabo(MedicamentLabo medicamentLabo) {
        return medicamentLaboRepository.save(medicamentLabo);
    }

    // Méthode pour supprimer un medicament_labo par son id
    public void deleteMedicamentLabo(Integer id) {
        medicamentLaboRepository.deleteById(id);
    }
}
