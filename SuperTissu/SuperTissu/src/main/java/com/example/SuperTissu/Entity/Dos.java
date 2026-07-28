package com.example.SuperTissu.Entity;

import jakarta.persistence.Entity;

@Entity
public class Dos extends Produit {

    private Integer hauteur;

    public Integer getHauteur() {
        return hauteur;
    }

    public void setHauteur(Integer hauteur) {
        this.hauteur = hauteur;
    }
}
