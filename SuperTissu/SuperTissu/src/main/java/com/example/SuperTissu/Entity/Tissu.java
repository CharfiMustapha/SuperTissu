package com.example.SuperTissu.Entity;

import jakarta.persistence.Entity;

@Entity
public class Tissu extends Produit {

    private String gamme;

    private String numeroReference;

    public String getGamme() {
        return gamme;
    }

    public void setGamme(String gamme) {
        this.gamme = gamme;
    }

    public String getNumeroReference() {
        return numeroReference;
    }

    public void setNumeroReference(String numeroReference) {
        this.numeroReference = numeroReference;
    }
}
