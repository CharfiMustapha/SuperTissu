package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.Watt;
import com.example.SuperTissu.Service.WattService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watts")
@CrossOrigin("*")
public class WattRestController {

    @Autowired
    private WattService wattService;

    @PostMapping
    public ResponseEntity<Watt> ajouterWatt(@RequestBody Watt watt) {
        Watt saved = wattService.ajouterWatt(watt);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Watt> modifierWatt(
            @PathVariable Long id,
            @RequestBody Watt watt) {
        watt.setIdProduit(id);
        Watt updated = wattService.modifierWatt(watt);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerWatt(@PathVariable Long id) {
        wattService.supprimerWatt(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Watt> getWattById(@PathVariable Long id) {
        return wattService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Watt>> getAllWatts() {
        return ResponseEntity.ok(wattService.findAll());
    }
}