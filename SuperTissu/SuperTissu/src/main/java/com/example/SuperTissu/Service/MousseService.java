package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Mousse;

import java.util.List;
import java.util.Optional;

public interface MousseService {
    Mousse ajouterMousse(Mousse mousse);
    Mousse modifierMousse(Mousse mousse);
    void supprimerMousse(Long id);
    Optional<Mousse> findById(Long id);
    List<Mousse> findAll();
}