package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Salon;
import java.util.List;
import java.util.Optional;

public interface SalonService {
    Salon ajouterSalon(Salon salon);
    Salon modifierSalon(Salon salon);
    void supprimerSalon(Long id);
    Optional<Salon> findById(Long id);
    List<Salon> findAll();
    List<Salon> findByNomSalon(String nomSalon);
}
