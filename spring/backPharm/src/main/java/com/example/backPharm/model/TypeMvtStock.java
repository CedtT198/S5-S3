package com.example.backPharm.model;
import jakarta.persistence.*;

@Entity
@Table(name = "type_mouvement_stock")
public class TypeMvtStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_mvt_stock")
    private Integer idTypeMvtStock;

    @Column(name = "nom_type_mvt_stock", nullable = false, length = 50)
    private String nomTypeMvtStock;
 
    
    public TypeMvtStock() {}
    public TypeMvtStock(String nomTypeMvtStock) {
        this.nomTypeMvtStock = nomTypeMvtStock;
    }

    // Getters et Setters
    public Integer getIdTypeMvtStock() {
        return idTypeMvtStock;
    }

    public void setIdTypeMvtStock(Integer idTypeMvtStock) {
        this.idTypeMvtStock = idTypeMvtStock;
    }

    public String getNomTypeMvtStock() {
        return nomTypeMvtStock;
    }

    public void setNomTypeMvtStock(String nomTypeMvtStock) {
        this.nomTypeMvtStock = nomTypeMvtStock;
    }
}
