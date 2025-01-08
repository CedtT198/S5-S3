package com.example.backPharm.model;
import jakarta.persistence.*;

@Entity
@Table(name = "poste")
public class Poste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poste")
    private Integer id_poste;

    @Column(name = "nom_poste", nullable = false, length = 50)
    private String nomPoste;

    
    public Poste() {}
    public Poste(String nomPoste) {
        this.nomPoste = nomPoste;
    }

    // Getters et Setters
    public Integer getid_poste() {
        return id_poste;
    }

    public void setid_poste(Integer id_poste) {
        this.id_poste = id_poste;
    }

    public String getNomPoste() {
        return nomPoste;
    }

    public void setNomPoste(String nomPoste) {
        this.nomPoste = nomPoste;
    }
}
