package com.example.backPharm.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "historique_poste")
public class HistoriquePoste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historique_poste")
    private Integer id_historique_poste;

    @Column(name = "date_debut", nullable = false)
    private Date date_debut;

    @Column(name = "date_fin")
    private Date date_fin;

    @ManyToOne
    @JoinColumn(name = "id_poste", nullable = false)
    private Poste poste;

    @ManyToOne
    @JoinColumn(name = "id_personnel", nullable = false)
    private Personnel personnel;

    

    public HistoriquePoste() {}
    public HistoriquePoste(Date date_debut, Date date_fin, Poste poste, Personnel personnel) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.poste = poste;
        this.personnel = personnel;
    }

    // Getters et Setters
    public Integer getid_historique_poste() {
        return id_historique_poste;
    }

    public void setid_historique_poste(Integer id_historique_poste) {
        this.id_historique_poste = id_historique_poste;
    }

    public Date getdate_debut() {
        return date_debut;
    }

    public void setdate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getdate_fin() {
        return date_fin;
    }

    public void setdate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }
}
