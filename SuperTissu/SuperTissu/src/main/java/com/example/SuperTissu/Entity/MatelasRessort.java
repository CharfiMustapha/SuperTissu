package com.example.SuperTissu.Entity;

import jakarta.persistence.Entity;

@Entity
public class MatelasRessort extends Produit {

    private String nom;

    private Integer largeur;

    private Integer longueur;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getLargeur() {
        return largeur;
    }

    public void setLargeur(Integer largeur) {
        this.largeur = largeur;
    }

    public Integer getLongueur() {
        return longueur;
    }

    public void setLongueur(Integer longueur) {
        this.longueur = longueur;
    }
}