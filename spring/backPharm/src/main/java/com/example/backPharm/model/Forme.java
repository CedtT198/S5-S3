package com.example.backPharm.model;
import jakarta.persistence.*;

@Entity
@Table(name = "forme")
public class Forme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_forme")
    private Integer idForme;

    @Column(name = "nom_forme", nullable = false, length = 50)
    private String nomForme;

    
    public Forme() {}
    public Forme(String nomForme) {
        this.nomForme = nomForme;
    }
    
    public Integer getIdForme() {
        return idForme;
    }
    public void setIdForme(Integer idForme) {
        this.idForme = idForme;
    }
    public String getNomForme() {
        return nomForme;
    }
    public void setNomForme(String nomForme) {
        this.nomForme = nomForme;
    }

}
