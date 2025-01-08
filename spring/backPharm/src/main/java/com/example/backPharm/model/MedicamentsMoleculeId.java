package com.example.backPharm.model;

import java.io.Serializable;
import java.util.Objects;

public class MedicamentsMoleculeId implements Serializable {

    private Integer id_molecule;
    private Integer id_med;

    public MedicamentsMoleculeId() {}
    public MedicamentsMoleculeId(Integer id_molecule, Integer id_med) {
        this.id_molecule = id_molecule;
        this.id_med = id_med;
    }

    // Getters and setters

    public Integer getId_molecule() {
        return id_molecule;
    }

    public void setId_molecule(Integer id_molecule) {
        this.id_molecule = id_molecule;
    }

    public Integer getId_med() {
        return id_med;
    }

    public void setId_med(Integer id_med) {
        this.id_med = id_med;
    }

    // equals() and hashCode() for composite key
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicamentsMoleculeId that = (MedicamentsMoleculeId) o;
        return Objects.equals(id_molecule, that.id_molecule) && Objects.equals(id_med, that.id_med);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_molecule, id_med);
    }
}
