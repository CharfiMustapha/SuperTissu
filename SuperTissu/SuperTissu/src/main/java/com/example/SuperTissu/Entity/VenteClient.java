package com.example.SuperTissu.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class VenteClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVenteClient;


    @ManyToOne
    private Client client;


    private LocalDate date;

    private Double total;

    private Double montantPaye;

    private Double resteAPayer;


    @OneToMany(mappedBy = "venteClient")
    private List<LigneVenteClient> lignes;

    public Long getIdVenteClient() {
        return idVenteClient;
    }

    public void setIdVenteClient(Long idVenteClient) {
        this.idVenteClient = idVenteClient;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(Double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public Double getResteAPayer() {
        return resteAPayer;
    }

    public void setResteAPayer(Double resteAPayer) {
        this.resteAPayer = resteAPayer;
    }

    public List<LigneVenteClient> getLignes() {
        return lignes;
    }

    public void setLignes(List<LigneVenteClient> lignes) {
        this.lignes = lignes;
    }
}
