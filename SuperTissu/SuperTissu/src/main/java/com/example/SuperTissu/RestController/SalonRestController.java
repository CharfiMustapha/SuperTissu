package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.Salon;
import com.example.SuperTissu.Service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/salons")
@CrossOrigin("*")
public class SalonRestController {

    @Autowired
    private SalonService salonService;

    @PostMapping
    public ResponseEntity<Salon> ajouterSalon(
            @RequestBody Salon salon) {
        Salon savedSalon = salonService.ajouterSalon(salon);
        return new ResponseEntity<>(
                savedSalon,
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salon> modifierSalon(
            @PathVariable Long id,
            @RequestBody Salon salon) {
        salon.setIdSalon(id);
        Salon updatedSalon =
                salonService.modifierSalon(salon);
        return ResponseEntity.ok(updatedSalon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerSalon(
            @PathVariable Long id) {
        salonService.supprimerSalon(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salon> getSalonById(
            @PathVariable Long id) {
        return salonService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Salon>> getAllSalons() {
        List<Salon> salons =
                salonService.findAll();
        return ResponseEntity.ok(salons);
    }

    @GetMapping("/search/{nom}")
    public ResponseEntity<List<Salon>> rechercherSalon(
            @PathVariable String nom) {
        List<Salon> salons =
                salonService.findByNomSalon(nom);
        return ResponseEntity.ok(salons);
    }
}