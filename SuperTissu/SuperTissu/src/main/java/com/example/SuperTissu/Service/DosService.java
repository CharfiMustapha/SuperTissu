package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Dos;
import java.util.List;
import java.util.Optional;

public interface DosService {
    Dos ajouterDos(Dos dos);
    Dos modifierDos(Dos dos);
    void supprimerDos(Long id);
    Optional<Dos> findById(Long id);
    List<Dos> findAll();
}