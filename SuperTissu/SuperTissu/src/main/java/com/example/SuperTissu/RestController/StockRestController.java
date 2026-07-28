package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.Stock;
import com.example.SuperTissu.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/stocks")
@CrossOrigin("*")
public class StockRestController {
    @Autowired
    private StockService stockService;

    // Ajouter stock
    @PostMapping
    public ResponseEntity<Stock> ajouterStock(
            @RequestBody Stock stock) {
        Stock savedStock = stockService.ajouterStock(stock);
        return new ResponseEntity<>(
                savedStock,
                HttpStatus.CREATED
        );
    }

    // Modifier quantité stock
    @PutMapping("/{id}")
    public ResponseEntity<Stock> modifierStock(
            @PathVariable Long id,
            @RequestBody Stock stock) {
        Stock updatedStock = stockService.modifierStock(id, stock.getQuantite());
        return ResponseEntity.ok(updatedStock);
    }

    // Supprimer stock
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerStock(
            @PathVariable Long id) {
        stockService.supprimerStock(id);
        return ResponseEntity.noContent().build();
    }

    // Get stock by id
    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(
            @PathVariable Long id) {
        return stockService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Get all stocks
    @GetMapping
    public ResponseEntity<List<Stock>> getAllStocks() {
        List<Stock> stocks =
                stockService.findAll();
        return ResponseEntity.ok(stocks);
    }

    // Get stock by product
    @GetMapping("/produit/{idProduit}")
    public ResponseEntity<Stock> getStockByProduit(
            @PathVariable Long idProduit) {
        return stockService.findByProduitId(idProduit)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}