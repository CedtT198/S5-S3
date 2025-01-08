package com.example.backPharm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medicaments")
public class Medicaments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_med")
    private Integer idMed;

    @Column(name = "nom_med", nullable = false, length = 50)
    private String nomMed;

    @Column(name = "notice", nullable = false, length = 1000)
    private String notice;

    @ManyToOne
    @JoinColumn(name = "id_type_med", nullable = false)
    private TypeMedicament typeMedicament;
    
    @ManyToOne
    @JoinColumn(name = "id_forme", nullable = false)
    private Forme forme;
    

    public Medicaments() {}
    public Medicaments(String nom_med, String notice, TypeMedicament typeMedicament) {
        this.nomMed = nom_med;
        this.notice = notice;
        this.typeMedicament = typeMedicament;
    }

    // Getters et Setters
    
    public Integer getid_med() {
        return idMed;
    }

    public Forme getForme() {
        return forme;
    }
    public void setForme(Forme forme) {
        this.forme = forme;
    }
    public void setid_med(Integer idMed) {
        this.idMed = idMed;
    }

    public String getnom_med() {
        return nomMed;
    }

    public void setnom_med(String nom_med) {
        this.nomMed = nom_med;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public TypeMedicament getTypeMedicament() {
        return typeMedicament;
    }

    public void setTypeMedicament(TypeMedicament typeMedicament) {
        this.typeMedicament = typeMedicament;
    }
}
