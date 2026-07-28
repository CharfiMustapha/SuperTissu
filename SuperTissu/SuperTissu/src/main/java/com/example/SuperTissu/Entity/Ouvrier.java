package com.example.SuperTissu.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ouvrier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOuvrier;


    private String nom;

    private Double salaire;

    private Double avanceSalaire;

    private Integer nombreHeureSupplementaire;

    private Double prixHeureSupplementaire;

    public Long getIdOuvrier() {
        return idOuvrier;
    }

    public void setIdOuvrier(Long idOuvrier) {
        this.idOuvrier = idOuvrier;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    public Double getAvanceSalaire() {
        return avanceSalaire;
    }

    public void setAvanceSalaire(Double avanceSalaire) {
        this.avanceSalaire = avanceSalaire;
    }

    public Integer getNombreHeureSupplementaire() {
        return nombreHeureSupplementaire;
    }

    public void setNombreHeureSupplementaire(Integer nombreHeureSupplementaire) {
        this.nombreHeureSupplementaire = nombreHeureSupplementaire;
    }

    public Double getPrixHeureSupplementaire() {
        return prixHeureSupplementaire;
    }

    public void setPrixHeureSupplementaire(Double prixHeureSupplementaire) {
        this.prixHeureSupplementaire = prixHeureSupplementaire;
    }
}
