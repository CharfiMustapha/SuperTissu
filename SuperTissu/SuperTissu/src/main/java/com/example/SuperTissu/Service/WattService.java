package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Watt;

import java.util.List;
import java.util.Optional;

public interface WattService {
    Watt ajouterWatt(Watt watt);
    Watt modifierWatt(Watt watt);
    void supprimerWatt(Long id);
    Optional<Watt> findById(Long id);
    List<Watt> findAll();
}