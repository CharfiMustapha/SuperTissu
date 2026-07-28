package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Tissu;
import java.util.List;
import java.util.Optional;

public interface TissuService {
    Tissu ajouterTissu(Tissu tissu);
    Tissu modifierTissu(Tissu tissu);
    void supprimerTissu(Long id);
    Optional<Tissu> findById(Long id);
    List<Tissu> findAll();
}