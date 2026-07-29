package com.example.SuperTissu.Repository;

import com.example.SuperTissu.Entity.Mousse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MousseRepository extends JpaRepository<Mousse, Long> {
}