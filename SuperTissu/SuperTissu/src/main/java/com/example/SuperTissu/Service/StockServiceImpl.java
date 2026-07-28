package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Stock;
import com.example.SuperTissu.Repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StockServiceImpl implements StockService {
    @Autowired
    private StockRepository stockRepository;

    @Override
    public Stock ajouterStock(Stock stock) {
        Optional<Stock> existingStock =
                stockRepository.findByProduitIdProduit(
                        stock.getProduit().getIdProduit()
                );
        // If product already exists in stock, add quantity
        if(existingStock.isPresent()) {
            Stock ancienStock = existingStock.get();
            ancienStock.setQuantite(
                    ancienStock.getQuantite() + stock.getQuantite()
            );
            return stockRepository.save(ancienStock);
        }
        return stockRepository.save(stock);
    }

    @Override
    public Stock modifierStock(Long id, Double quantite) {
        Stock stock = stockRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Stock non trouvé avec l'id : " + id));
        if (quantite <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "La quantité doit être supérieure à 0.");
        }
        if (stock.getQuantite() < quantite) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Stock insuffisant.");
        }
        stock.setQuantite(stock.getQuantite() - quantite);

        return stockRepository.save(stock);
    }

    @Override
    public void supprimerStock(Long id) {
        if(stockRepository.existsById(id)) {

            stockRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Stock non trouvé avec l'id: " + id
            );
        }
    }

    @Override
    public Optional<Stock> findById(Long id) {
        return stockRepository.findById(id);
    }

    @Override
    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    @Override
    public Optional<Stock> findByProduitId(Long idProduit) {
        return stockRepository.findByProduitIdProduit(idProduit);
    }
}