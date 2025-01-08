package com.example.backPharm.model;
import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "salaire")
public class Salaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_salaire")
    private Integer idSalaire;

    @Column(name = "date_salaire", nullable = false)
    private Date dateSalaire;

    @Column(name = "montant_salaire", nullable = false)
    private double montantSalaire;

    @ManyToOne
    @JoinColumn(name = "id_personnel", nullable = false)
    private Personnel personnel;

    
    public Salaire() {}
    public Salaire(Date dateSalaire, double montantSalaire, Personnel personnel) {
        this.dateSalaire = dateSalaire;
        this.montantSalaire = montantSalaire;
        this.personnel = personnel;
    }

    // Getters et Setters
    public Integer getIdSalaire() {
        return idSalaire;
    }

    public void setIdSalaire(Integer idSalaire) {
        this.idSalaire = idSalaire;
    }

    public Date getDateSalaire() {
        return dateSalaire;
    }

    public void setDateSalaire(Date dateSalaire) {
        this.dateSalaire = dateSalaire;
    }

    public double getMontantSalaire() {
        return montantSalaire;
    }

    public void setMontantSalaire(double montantSalaire) {
        this.montantSalaire = montantSalaire;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
}
