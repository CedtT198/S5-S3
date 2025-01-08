package com.example.backPharm.service;

import com.example.backPharm.model.TypeMvtStock;
import com.example.backPharm.repository.TypeMvtStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TypeMvtStockService {

    @Autowired
    private TypeMvtStockRepository typeMvtStockRepository;

    // Trouver tous les types de mouvement de stock
    public List<TypeMvtStock> findAll() {
        return typeMvtStockRepository.findAll();
    }

    // Trouver un type de mouvement de stock par son ID
    public Optional<TypeMvtStock> findById(Integer id) {
        return typeMvtStockRepository.findById(id);
    }

    // Sauvegarder un nouveau type de mouvement de stock
    public TypeMvtStock save(TypeMvtStock typeMvtStock) {
        return typeMvtStockRepository.save(typeMvtStock);
    }

    // Supprimer un type de mouvement de stock
    public void delete(Integer id) {
        typeMvtStockRepository.deleteById(id);
    }

    // Mettre à jour un type de mouvement de stock
    public TypeMvtStock update(Integer id, TypeMvtStock typeMvtStock) {
        if (typeMvtStockRepository.existsById(id)) {
            typeMvtStock.setIdTypeMvtStock(id);  // Assurez-vous que l'ID est celui à mettre à jour.
            return typeMvtStockRepository.save(typeMvtStock);
        }
        return null; // ou une exception personnalisée si le typeMvtStock n'existe pas
    }
}
