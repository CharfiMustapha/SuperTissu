package com.example.SuperTissu.Entity;

import jakarta.persistence.Entity;

@Entity
public class MatelasMousse extends Produit {

    private String densite;

    private Integer epaisseur;

    public String getDensite() {
        return densite;
    }

    public void setDensite(String densite) {
        this.densite = densite;
    }

    public Integer getEpaisseur() {
        return epaisseur;
    }

    public void setEpaisseur(Integer epaisseur) {
        this.epaisseur = epaisseur;
    }
}