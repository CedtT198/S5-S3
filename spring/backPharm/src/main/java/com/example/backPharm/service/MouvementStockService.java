package com.example.backPharm.service;

import com.example.backPharm.model.MouvementStock;
import com.example.backPharm.repository.MouvementStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MouvementStockService {

    @Autowired
    private MouvementStockRepository mouvementStockRepository;
    
    public List<MouvementStock> findSoldMedicamentByDate(Date date) {
        return mouvementStockRepository.findByDateMvtStock(date);
    }

    public int calculateStockDifference(Integer idMed) {
        return mouvementStockRepository.totalInputByMed(idMed) - mouvementStockRepository.totalOutputByMed(idMed) ;
    }

    public List<Object[]> remainingStockByMed() {
        return mouvementStockRepository.remainingStockByMed() ;
    }

    public List<MouvementStock> findAllByTypeMvtStock(Integer id) {
        return mouvementStockRepository.findAllByTypeMouvementStock_IdTypeMvtStock(id);
    }

    public List<MouvementStock> findSoldMedicamentByFormePatient(Integer idForme, Integer idPatient) {
        return mouvementStockRepository.findSoldMedicamentByFormePatient(idForme, idPatient);
    }
    
    // Trouver tous les mouvements de stock
    public List<MouvementStock> findAll() {
        // return mouvementStockRepository.findAll();
        return mouvementStockRepository.findAllByOrderByDateMvtStockDesc();
    }

    // Trouver un mouvement de stock par son ID
    public Optional<MouvementStock> findById(Integer id) {
        return mouvementStockRepository.findById(id);
    }

    // Sauvegarder un nouveau mouvement de stock
    public MouvementStock save(MouvementStock mouvementStock) {
        return mouvementStockRepository.save(mouvementStock);
    }

    // Supprimer un mouvement de stock
    public void delete(Integer id) {
        mouvementStockRepository.deleteById(id);
    }

    // Mettre à jour un mouvement de stock
    public MouvementStock update(Integer id, MouvementStock mouvementStock) {
        if (mouvementStockRepository.existsById(id)) {
            mouvementStock.setIdMvtStock(id);  // Assurez-vous que l'ID est celui à mettre à jour.
            return mouvementStockRepository.save(mouvementStock);
        }
        return null; // ou une exception personnalisée si le mouvement de stock n'existe pas
    }
}
