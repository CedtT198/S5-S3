package com.example.backPharm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "medicament_labo")
public class MedicamentLabo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_medicament_labo")
    private Long idMedicamentLabo;

    @ManyToOne
    @JoinColumn(name = "id_laboratoire", nullable = false)
    private Laboratoire laboratoire;

    @ManyToOne
    @JoinColumn(name = "id_med", nullable = false)
    private Medicaments medicament;

    public MedicamentLabo() {}

    public MedicamentLabo(Laboratoire laboratoire, Medicaments medicament) {
        this.laboratoire = laboratoire;
        this.medicament = medicament;
    }

    // Getters et Setters
    public Long getIdMedicamentLabo() {
        return idMedicamentLabo;
    }

    public void setIdMedicamentLabo(Long idMedicamentLabo) {
        this.idMedicamentLabo = idMedicamentLabo;
    }

    public Laboratoire getLaboratoire() {
        return laboratoire;
    }

    public void setLaboratoire(Laboratoire laboratoire) {
        this.laboratoire = laboratoire;
    }

    public Medicaments getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicaments medicament) {
        this.medicament = medicament;
    }
}
