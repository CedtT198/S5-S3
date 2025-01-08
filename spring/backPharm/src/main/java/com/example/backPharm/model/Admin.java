package com.example.backPharm.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admin")
public class Admin {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Integer id_admin;

    @Column(name = "nom_admin", nullable = false, length = 50)
    private String nomAdmin;
    
    @Column(name = "mdp", nullable = false, length = 50)
    private String mdp;


    public Admin() {}
    public Admin(String nomAdmin, String mdp) {
        this.nomAdmin = nomAdmin;
        this.mdp = mdp;
    }
    public Admin(Integer id_admin, String nomAdmin, String mdp) {
        this.id_admin = id_admin;
        this.nomAdmin = nomAdmin;
        this.mdp = mdp;
    }

    public Integer getId_admin() {
        return id_admin;
    }

    public void setId_admin(Integer id_admin) {
        this.id_admin = id_admin;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    
    
}
