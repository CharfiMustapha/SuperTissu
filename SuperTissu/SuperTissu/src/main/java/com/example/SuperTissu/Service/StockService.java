package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Stock;
import java.util.List;
import java.util.Optional;

public interface StockService {
    Stock ajouterStock(Stock stock);
    Stock modifierStock(Long id, Double quantite);
    void supprimerStock(Long id);
    Optional<Stock> findById(Long id);
    List<Stock> findAll();
    Optional<Stock> findByProduitId(Long idProduit);
}