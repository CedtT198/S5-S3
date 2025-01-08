package com.example.backPharm.repository;

import com.example.backPharm.model.MouvementStock;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MouvementStockRepository extends JpaRepository<MouvementStock, Integer> {
    public List<MouvementStock> findAllByTypeMouvementStock_IdTypeMvtStock(Integer id);
    @Query("SELECT COALESCE(SUM(ms.quantite), 0) FROM MouvementStock ms WHERE ms.medicament.idMed = :idMed AND ms.typeMouvementStock.idTypeMvtStock = 1")
    int totalInputByMed(Integer idMed);

    @Query("SELECT COALESCE(SUM(ms.quantite), 0) FROM MouvementStock ms WHERE ms.medicament.idMed = :idMed AND ms.typeMouvementStock.idTypeMvtStock = 2")
    int totalOutputByMed(Integer idMed);
    
    @Query("SELECT ms.medicament.nomMed, (COALESCE(SUM(CASE WHEN ms.typeMouvementStock.idTypeMvtStock = 1 THEN ms.quantite ELSE 0 END), 0) -"+ 
            "COALESCE(SUM(CASE WHEN ms.typeMouvementStock.idTypeMvtStock = 2 THEN ms.quantite ELSE 0 END), 0)) as stockRestant "+
            "FROM MouvementStock ms GROUP BY ms.medicament.nomMed")
    List<Object[]> remainingStockByMed();
}

