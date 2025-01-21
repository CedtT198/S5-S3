package com.example.backPharm.repository;

import com.example.backPharm.model.Medicaments;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicamentsRepository extends JpaRepository<Medicaments, Integer> {
    public List<Medicaments> findAllByOrderByNomMedAsc();
    public List<Medicaments> findAllByOrderByNomMedDesc();
    public List<Medicaments> findAllByTypeMedicament_IdTypeMed(Integer idtype);
    public List<Medicaments> findAllByForme_IdForme(Integer idforme);

    @Query("SELECT p.medicament FROM Posologie p WHERE p.maladie.id_Maladie = :idMaladie AND p.patient.idPatient = :idPatient")
    List<Medicaments> findMedicamentsByMaladieAndPatient(@Param("idMaladie") Integer idMaladie, @Param("idPatient") Integer idPatient);
}

