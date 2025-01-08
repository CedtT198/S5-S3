package com.example.backPharm.model;

import jakarta.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "mouvement_stock")
public class MouvementStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mvt_stock")
    private Integer idMvtStock;

    @Column(name = "date_mvt_stock", nullable = false)
    private Date dateMvtStock;

    @Column(name = "quantite", nullable = false)
    private Integer quantite;

    @ManyToOne
    @JoinColumn(name = "id_med", nullable = false)
    private Medicaments medicament;

    @ManyToOne
    @JoinColumn(name = "id_type_mvt_stock", nullable = false)
    private TypeMvtStock typeMouvementStock;

    
    public MouvementStock() {}
    public MouvementStock(Date dateMvtStock, Integer quantite, Medicaments medicament,
            TypeMvtStock typeMouvementStock) {
        this.dateMvtStock = dateMvtStock;
        this.quantite = quantite;
        this.medicament = medicament;
        this.typeMouvementStock = typeMouvementStock;
    }

    // Getters et Setters
    public Integer getIdMvtStock() {
        return idMvtStock;
    }

    public void setIdMvtStock(Integer idMvtStock) {
        this.idMvtStock = idMvtStock;
    }

    public Date getDateMvtStock() {
        return dateMvtStock;
    }

    public void setDateMvtStock(Date dateMvtStock) {
        this.dateMvtStock = dateMvtStock;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Medicaments getMedicament() {
        return medicament;
    }

    public void setMedicament(Medicaments medicament) {
        this.medicament = medicament;
    }

    public TypeMvtStock getTypeMouvementStock() {
        return typeMouvementStock;
    }

    public void setTypeMouvementStock(TypeMvtStock typeMouvementStock) {
        this.typeMouvementStock = typeMouvementStock;
    }
    
}

