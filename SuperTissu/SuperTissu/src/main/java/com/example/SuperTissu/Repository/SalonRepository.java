package com.example.SuperTissu.Repository;

import com.example.SuperTissu.Entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SalonRepository extends JpaRepository<Salon, Long> {
    List<Salon> findByNomSalon(String nomSalon);
}