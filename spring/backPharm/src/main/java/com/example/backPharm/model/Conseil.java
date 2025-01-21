package com.example.backPharm.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "conseille")
public class Conseil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conseille")
    private Integer idConseil;

    @Column(name = "date_conseil", nullable = false)
    private Date dateConseil;

    @ManyToOne
    @JoinColumn(name = "id_med", nullable = false)
    private Medicaments medicament;

    public Conseil() {}
    public Conseil(Date dateConseil, Medicaments medicament) {
        this.dateConseil = dateConseil;
        this.medicament = medicament;
    }


    // Getters et setters
    public Integer getIdConseil() {
        return idConseil;
    }

    public void setIdConseil(Integer idConseil) {
        this.idConseil = idConseil;
    }

    public Date getDateConseil() {
        return dateConseil;
    }

    public void setDateConseil(Date dateConseil) {
        this.dateConseil = dateConseil;
    }

    public Medicaments getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicaments medicament) {
        this.medicament = medicament;
    }
}

