package com.example.backPharm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "type_medicament")
public class TypeMedicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_med")
    private Integer idTypeMed;

    @Column(name = "nom_type_med", nullable = false, length = 50)
    private String nomTypeMed;

    
    public TypeMedicament() {}
    public TypeMedicament(String nomTypeMed) {
        this.nomTypeMed = nomTypeMed;
    }

    // Getters et Setters
    public Integer getid_type_med() {
        return idTypeMed;
    }

    public void setid_type_med(Integer idTypeMed) {
        this.idTypeMed = idTypeMed;
    }

    public String getNomTypeMed() {
        return nomTypeMed;
    }

    public void setNomTypeMed(String nomTypeMed) {
        this.nomTypeMed = nomTypeMed;
    }

}
