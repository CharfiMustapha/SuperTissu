package com.example.SuperTissu.Entity;

import jakarta.persistence.Entity;

@Entity
public class Accoudoir extends Produit {

    private String forme;

    public String getForme() {
        return forme;
    }

    public void setForme(String forme) {
        this.forme = forme;
    }
}
