package com.example.backPharm.model;
import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "personnel")
public class Personnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personnel") 
    private Integer idPersonnel;

    @Column(name = "nom", nullable = false, length = 50)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;

    @Column(name = "date_naissance", nullable = false)
    private java.sql.Date dateNaissance;

    @Column(name = "ville_naissance", nullable = false, length = 50)
    private String villeNaissance;


    public Personnel() {}
    public Personnel(String nom, String prenom, Date dateNaissance, String villeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.villeNaissance = villeNaissance;
    }

    // Getters et Setters
    public Integer getid_personnel() {
        return idPersonnel;
    }

    public void setid_personnel(Integer idPersonnel) {
        this.idPersonnel = idPersonnel;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public java.sql.Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(java.sql.Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getVilleNaissance() {
        return villeNaissance;
    }

    public void setVilleNaissance(String villeNaissance) {
        this.villeNaissance = villeNaissance;
    }

    public String getNomComplet() {
        return this.nom+" "+prenom;
    }
}
