package com.example.backPharm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "laboratoire")
public class Laboratoire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_laboratoire")
    private Integer idLaboratoire;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    // Constructeurs
    public Laboratoire() {}

    public Laboratoire(String nom) {
        this.nom = nom;
    }

    // Getters et Setters
    public Integer getIdLaboratoire() {
        return idLaboratoire;
    }

    public void setIdLaboratoire(Integer idLaboratoire) {
        this.idLaboratoire = idLaboratoire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
