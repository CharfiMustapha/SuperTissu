package com.example.SuperTissu.Entity;

import jakarta.persistence.Entity;

@Entity
public class Mousse extends Produit {

    private Integer epaisseur;

    public Integer getEpaisseur() {
        return epaisseur;
    }

    public void setEpaisseur(Integer epaisseur) {
        this.epaisseur = epaisseur;
    }
}
