package com.example.backPharm.model;
import jakarta.persistence.*;

@Entity
@Table(name = "maladie")
public class Maladie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_maladie")
    private Integer id_Maladie;

    @Column(name = "nom_maladie", nullable = false, length = 50)
    private String nom_maladie;

    
    public Maladie() {}
    public Maladie(String nom_maladie) {
        this.nom_maladie = nom_maladie;
    }
    
    public Integer getId_Maladie() {
        return id_Maladie;
    }
    public void setId_Maladie(Integer id_Maladie) {
        this.id_Maladie = id_Maladie;
    }
    public String getNom_maladie() {
        return nom_maladie;
    }
    public void setNom_maladie(String nom_maladie) {
        this.nom_maladie = nom_maladie;
    }

}
