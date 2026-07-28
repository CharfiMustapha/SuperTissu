package com.example.SuperTissu.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class CommandeProduit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommandeProduit;


    @ManyToOne
    private Client client;


    private LocalDate dateCommande;

    private LocalDate dateLivraison;

    private String statut;


    @OneToMany(mappedBy = "commandeProduit")
    private List<LigneCommandeProduit> lignes;

    public Long getIdCommandeProduit() {
        return idCommandeProduit;
    }

    public void setIdCommandeProduit(Long idCommandeProduit) {
        this.idCommandeProduit = idCommandeProduit;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDate dateCommande) {
        this.dateCommande = dateCommande;
    }

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public List<LigneCommandeProduit> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneCommandeProduit> lignes) {
        this.lignes = lignes;
    }
}
