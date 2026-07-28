package com.example.SuperTissu.Entity;

import jakarta.persistence.*;

@Entity
public class LigneCommandeProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigneCommande;


    @ManyToOne
    private CommandeProduit commandeProduit;


    @ManyToOne
    private Produit produit;


    private Integer quantite;

    public Long getIdLigneCommande() {
        return idLigneCommande;
    }

    public void setIdLigneCommande(Long idLigneCommande) {
        this.idLigneCommande = idLigneCommande;
    }

    public CommandeProduit getCommandeProduit() {
        return commandeProduit;
    }

    public void setCommandeProduit(CommandeProduit commandeProduit) {
        this.commandeProduit = commandeProduit;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }
}
