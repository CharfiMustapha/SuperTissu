package com.example.SuperTissu.Entity;

import jakarta.persistence.Entity;

@Entity
public class Graffe extends Produit {

    private String  taille;

    public String  getTaille() {
        return taille;
    }

    public void setTaille(String  taille) {
        this.taille = taille;
    }
}
