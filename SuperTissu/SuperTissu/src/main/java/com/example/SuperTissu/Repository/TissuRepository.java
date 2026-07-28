package com.example.SuperTissu.Repository;

import com.example.SuperTissu.Entity.Tissu;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TissuRepository extends JpaRepository<Tissu, Long> {
    Optional<Tissu> findByGamme(String gamme);
    Optional<Tissu> findByNumeroReference(String numeroReference);
}