package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.MatelasRessort;

import java.util.List;
import java.util.Optional;

public interface MatelasRessortService {
    MatelasRessort ajouterMatelasRessort(MatelasRessort matelasRessort);
    MatelasRessort modifierMatelasRessort(MatelasRessort matelasRessort);
    void supprimerMatelasRessort(Long id);
    Optional<MatelasRessort> findById(Long id);
    List<MatelasRessort> findAll();
}