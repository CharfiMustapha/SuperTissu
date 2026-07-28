package com.example.SuperTissu.Entity;

import jakarta.persistence.Entity;

@Entity
public class Watt extends Produit {

    private Double epaisseur;

    public Double getEpaisseur() {
        return epaisseur;
    }

    public void setEpaisseur(Double epaisseur) {
        this.epaisseur = epaisseur;
    }
}
