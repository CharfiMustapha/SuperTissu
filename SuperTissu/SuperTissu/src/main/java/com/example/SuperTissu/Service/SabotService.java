package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Sabot;

import java.util.List;
import java.util.Optional;

public interface SabotService {
    Sabot ajouterSabot(Sabot sabot);
    Sabot modifierSabot(Sabot sabot);
    void supprimerSabot(Long id);
    Optional<Sabot> findById(Long id);
    List<Sabot> findAll();
}