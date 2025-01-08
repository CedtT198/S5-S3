package com.example.backPharm.service;

import com.example.backPharm.model.Personnel;
import com.example.backPharm.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonnelService {

    @Autowired
    private PersonnelRepository personnelRepository;

    public List<Personnel> findAllByOrderByNomAsc() {
        return personnelRepository.findAllByOrderByNomAsc();
    }
    
    public List<Personnel> findAllByOrderByNomDesc() {
        return personnelRepository.findAllByOrderByNomDesc();
    }
    
    // Trouver tous les postes
    public List<Personnel> findAll() {
        return personnelRepository.findAll();
    }

    // Trouver un poste par son ID
    public Optional<Personnel> findById(Integer id) {
        return personnelRepository.findById(id);
    }

    // Sauvegarder un nouveau poste
    public Personnel save(Personnel poste) {
        return personnelRepository.save(poste);
    }

    // Supprimer un poste
    public void delete(Integer id) {
        personnelRepository.deleteById(id);
    }

    // Mettre à jour un poste
    public Personnel update(Integer id, Personnel poste) {
        if (personnelRepository.existsById(id)) {
            poste.setid_personnel(id);  // Assurez-vous que l'ID est celui à mettre à jour.
            return personnelRepository.save(poste);
        }
        return null; // ou une exception personnalisée si le poste n'existe pas
    }
}
