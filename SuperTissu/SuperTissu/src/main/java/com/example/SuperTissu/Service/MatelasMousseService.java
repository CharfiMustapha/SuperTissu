package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.MatelasMousse;

import java.util.List;
import java.util.Optional;

public interface MatelasMousseService {
    MatelasMousse ajouterMatelasMousse(MatelasMousse matelasMousse);
    MatelasMousse modifierMatelasMousse(MatelasMousse matelasMousse);
    void supprimerMatelasMousse(Long id);
    Optional<MatelasMousse> findById(Long id);
    List<MatelasMousse> findAll();
}