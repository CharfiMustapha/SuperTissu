package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Graffe;
import java.util.List;
import java.util.Optional;

public interface GraffeService {
    Graffe ajouterGraffe(Graffe graffe);
    Graffe modifierGraffe(Graffe graffe);
    void supprimerGraffe(Long id);
    Optional<Graffe> findById(Long id);
    List<Graffe> findAll();
}