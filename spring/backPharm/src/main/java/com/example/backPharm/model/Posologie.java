package com.example.backPharm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "notice")
public class Posologie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_notice")
    private Integer idPosologie;

    @Column(name = "dose", nullable = false)
    private Integer dose;
 
    @Column(name = "frequence", nullable = false)
    private Double frequence;

    @Column(name = "duree", nullable = false)
    private Integer duree;

    @ManyToOne
    @JoinColumn(name = "id_maladie", referencedColumnName = "id_maladie", nullable = false)
    private Maladie maladie;

    @ManyToOne
    @JoinColumn(name = "id_patient", referencedColumnName = "id_patient", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_med", referencedColumnName = "id_med", nullable = false)
    private Medicaments medicament;

    public Posologie() {}

    public Posologie(Integer dose, Double frequence, Integer duree, Maladie maladie, Patient patient, Medicaments medicament) {
        this.dose = dose;
        this.frequence = frequence;
        this.duree = duree;
        this.maladie = maladie;
        this.patient = patient;
        this.medicament = medicament;
    }

    // Getters et Setters
    public Integer getIdPosologie() {
        return idPosologie;
    }

    public void setIdPosologie(Integer idPosologie) {
        this.idPosologie = idPosologie;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public Double getFrequence() {
        return frequence;
    }

    public void setFrequence(Double frequence) {
        this.frequence = frequence;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Maladie getMaladie() {
        return maladie;
    }

    public void setMaladie(Maladie maladie) {
        this.maladie = maladie;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Medicaments getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicaments medicament) {
        this.medicament = medicament;
    }
}
