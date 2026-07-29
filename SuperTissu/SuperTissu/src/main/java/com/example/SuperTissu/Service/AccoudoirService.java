package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Accoudoir;

import java.util.List;
import java.util.Optional;

public interface AccoudoirService {
    Accoudoir ajouterAccoudoir(Accoudoir accoudoir);
    Accoudoir modifierAccoudoir(Accoudoir accoudoir);
    void supprimerAccoudoir(Long id);
    Optional<Accoudoir> findById(Long id);
    List<Accoudoir> findAll();
}