package com.example.backPharm.service;

import com.example.backPharm.model.Medicaments;
import com.example.backPharm.repository.MedicamentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MedicamentsService {

    @Autowired
    private MedicamentsRepository medicamentsRepository;

    public List<Medicaments> findAllByTypeMedicament(Integer idtype) {
        return medicamentsRepository.findAllByTypeMedicament_IdTypeMed(idtype);
    }
    
    public List<Medicaments> findAllByForme(Integer idforme) {
        return medicamentsRepository.findAllByForme_IdForme(idforme);
    }

    public List<Medicaments> findMedicamentsByMaladieAndPatient(Integer idMal, Integer idPat) {
        return medicamentsRepository.findMedicamentsByMaladieAndPatient(idMal, idPat);
    }

    public List<Medicaments> findAllByNameOrderAsc() {
        return medicamentsRepository.findAllByOrderByNomMedAsc();
    }
    
    public List<Medicaments> findAllByNameOrderDesc() {
        return medicamentsRepository.findAllByOrderByNomMedDesc();
    }
    
    // Trouver tous les médicaments
    public List<Medicaments> findAll() {
        return medicamentsRepository.findAll();
    }

    // Trouver un médicament par son ID
    public Optional<Medicaments> findById(Integer id) {
        return medicamentsRepository.findById(id);
    }

    // Sauvegarder un nouveau médicament
    public Medicaments save(Medicaments medicament) {
        return medicamentsRepository.save(medicament);
    }

    // Supprimer un médicament
    public void delete(Integer id) {
        medicamentsRepository.deleteById(id);
    }

    // Mettre à jour un médicament
    public Medicaments update(Integer id, Medicaments medicament) {
        if (medicamentsRepository.existsById(id)) {
            medicament.setid_med(id);  // Assurez-vous que l'ID est celui à mettre à jour.
            return medicamentsRepository.save(medicament);
        }
        return null; // ou une exception personnalisée si le médicament n'existe pas
    }
}
