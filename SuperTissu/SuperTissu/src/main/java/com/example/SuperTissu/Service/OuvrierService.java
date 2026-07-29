package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Ouvrier;
import java.util.List;
import java.util.Optional;

public interface OuvrierService {
    Ouvrier ajouterOuvrier(Ouvrier ouvrier);
    Ouvrier modifierOuvrier(Ouvrier ouvrier);
    void supprimerOuvrier(Long id);
    Optional<Ouvrier> findById(Long id);
    List<Ouvrier> findAll();
    Ouvrier ajouterAvanceSalaire(Long id, Double montant);
    Ouvrier ajouterHeureSupplementaire(Long id, Integer nombreHeure);
    Double calculerSalaire(Long idOuvrier);
}