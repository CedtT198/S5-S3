package com.example.backPharm.service;

import com.example.backPharm.model.TypeMedicament;
import com.example.backPharm.repository.TypeMedicamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TypeMedicamentService {

    @Autowired
    private TypeMedicamentRepository typeMedicamentRepository;

    // Trouver tous les types de médicaments
    public List<TypeMedicament> findAll() {
        return typeMedicamentRepository.findAll();
    }

    // Trouver un type de médicament par son ID
    public Optional<TypeMedicament> findById(Integer id) {
        return typeMedicamentRepository.findById(id);
    }

    // Sauvegarder un nouveau type de médicament
    public TypeMedicament save(TypeMedicament typeMedicament) {
        return typeMedicamentRepository.save(typeMedicament);
    }

    // Supprimer un type de médicament
    public void delete(Integer id) {
        typeMedicamentRepository.deleteById(id);
    }

    // Mettre à jour un type de médicament
    public TypeMedicament update(Integer id, TypeMedicament typeMedicament) {
        if (typeMedicamentRepository.existsById(id)) {
            typeMedicament.setid_type_med(id);  // Assurez-vous que l'ID est celui à mettre à jour.
            return typeMedicamentRepository.save(typeMedicament);
        }
        return null; // ou une exception personnalisée si le typeMedicament n'existe pas
    }
}
