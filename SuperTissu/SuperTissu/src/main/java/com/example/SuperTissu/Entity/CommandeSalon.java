package com.example.SuperTissu.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class CommandeSalon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCommandeSalon;


    @ManyToOne
    private Client client;


    private String nomSalon;

    private String tissuUni;

    private String tissuFleuri;

    private String description;


    private LocalDate dateCommande;

    private LocalDate dateLivraison;

    private String statut;

    public Long getIdCommandeSalon() {
        return idCommandeSalon;
    }

    public void setIdCommandeSalon(Long idCommandeSalon) {
        this.idCommandeSalon = idCommandeSalon;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getNomSalon() {
        return nomSalon;
    }

    public void setNomSalon(String nomSalon) {
        this.nomSalon = nomSalon;
    }

    public String getTissuUni() {
        return tissuUni;
    }

    public void setTissuUni(String tissuUni) {
        this.tissuUni = tissuUni;
    }

    public String getTissuFleuri() {
        return tissuFleuri;
    }

    public void setTissuFleuri(String tissuFleuri) {
        this.tissuFleuri = tissuFleuri;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
}
