package com.example.SuperTissu.Entity;

import jakarta.persistence.Entity;

@Entity
public class Sabot extends Produit {

    private String gamme;

    private String couleur;

    public String getGamme() {
        return gamme;
    }

    public void setGamme(String gamme) {
        this.gamme = gamme;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }
}
