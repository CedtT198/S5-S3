package com.example.backPharm.repository;

import com.example.backPharm.model.Medicaments;
import com.example.backPharm.model.MouvementStock;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MouvementStockRepository extends JpaRepository<MouvementStock, Integer> {
    public List<MouvementStock> findAllByOrderByDateMvtStockDesc();
    public List<MouvementStock> findAllByTypeMouvementStock_IdTypeMvtStock(Integer id);
    @Query("SELECT COALESCE(SUM(ms.quantite), 0) FROM MouvementStock ms WHERE ms.medicament.idMed = :idMed AND ms.typeMouvementStock.idTypeMvtStock = 1")
    int totalInputByMed(Integer idMed);

    @Query("SELECT COALESCE(SUM(ms.quantite), 0) FROM MouvementStock ms WHERE ms.medicament.idMed = :idMed AND ms.typeMouvementStock.idTypeMvtStock = 2")
    int totalOutputByMed(Integer idMed);
    
    @Query("SELECT ms.medicament.nomMed, (COALESCE(SUM(CASE WHEN ms.typeMouvementStock.idTypeMvtStock = 1 THEN ms.quantite ELSE 0 END), 0) -"+ 
            "COALESCE(SUM(CASE WHEN ms.typeMouvementStock.idTypeMvtStock = 2 THEN ms.quantite ELSE 0 END), 0)) as stockRestant "+
            "FROM MouvementStock ms GROUP BY ms.medicament.nomMed")
    List<Object[]> remainingStockByMed();
    
    @Query("SELECT ms FROM MouvementStock ms JOIN Medicaments m ON ms.medicament.idMed = m.idMed "+
            "JOIN Posologie p ON m.idMed = p.medicament.idMed WHERE m.forme.idForme = :idForme AND p.patient.idPatient = :idPatient AND ms.typeMouvementStock.idTypeMvtStock = 2")
    List<MouvementStock> findSoldMedicamentByFormePatient(@Param("idForme") Integer idForme, @Param("idPatient") Integer idPatient);
    
//     List<MouvementStock> findByDateMvtStock(Date date);

        @Query("SELECT ms FROM MouvementStock ms WHERE ms.dateMvtStock = :date AND ms.typeMouvementStock.idTypeMvtStock = 2")
        List<MouvementStock> findByDateMvtStock(@Param("date") Date date);
}


