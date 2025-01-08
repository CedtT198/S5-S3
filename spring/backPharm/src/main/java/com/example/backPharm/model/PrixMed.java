package com.example.backPharm.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "prix_med")
public class PrixMed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prix_med")
    private Integer idPrixMed;

    @Column(name = "montant", nullable = false)
    private Double montant;

    @Column(name = "date_prix", nullable = false)
    private Date datePrix;

    @ManyToOne
    @JoinColumn(name = "id_med", nullable = false)
    private Medicaments medicament;


    public PrixMed() {}
    public PrixMed(Double montant, Date datePrix, Medicaments medicament) {
        this.montant = montant;
        this.datePrix = datePrix;
        this.medicament = medicament;
    }

    // Getters et Setters
    public Integer getIdPrixMed() {
        return idPrixMed;
    }

    public void setIdPrixMed(Integer idPrixMed) {
        this.idPrixMed = idPrixMed;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Date getDatePrix() {
        return datePrix;
    }

    public void setDatePrix(Date datePrix) {
        this.datePrix = datePrix;
    }

    public Medicaments getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicaments medicament) {
        this.medicament = medicament;
    }
}

