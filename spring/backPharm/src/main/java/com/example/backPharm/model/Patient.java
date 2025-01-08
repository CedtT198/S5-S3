package com.example.backPharm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_patient") 
    private Integer idPatient;

    @Column(name = "age_min", nullable = false)
    private Integer ageMin;

    @Column(name = "age_max", nullable = false)
    private Integer ageMax;

    public Patient() {}

    public Patient(Integer ageMin, Integer ageMax) {
        this.ageMin = ageMin;
        this.ageMax = ageMax;
    }

    // Getters et Setters
    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }
    
    public String getAge() {
        return this.getAgeMin() +" et "+this.getAgeMax() ;
    }
}
