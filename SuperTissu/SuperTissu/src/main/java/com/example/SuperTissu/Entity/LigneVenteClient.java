package com.example.SuperTissu.Entity;

import jakarta.persistence.*;

@Entity
public class LigneVenteClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigneVente;


    @ManyToOne
    private VenteClient venteClient;


    @ManyToOne
    private Produit produit;


    private Integer quantite;

    private Double prixUnitaire;

    private Double sousTotal;

    public Long getIdLigneVente() {
        return idLigneVente;
    }

    public void setIdLigneVente(Long idLigneVente) {
        this.idLigneVente = idLigneVente;
    }

    public VenteClient getVenteClient() {
        return venteClient;
    }

    public void setVenteClient(VenteClient venteClient) {
        this.venteClient = venteClient;
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

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public Double getSousTotal() {
        return sousTotal;
    }

    public void setSousTotal(Double sousTotal) {
        this.sousTotal = sousTotal;
    }
}
