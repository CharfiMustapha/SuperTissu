package com.example.SuperTissu.Repository;

import com.example.SuperTissu.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByProduitIdProduit(Long idProduit);
}