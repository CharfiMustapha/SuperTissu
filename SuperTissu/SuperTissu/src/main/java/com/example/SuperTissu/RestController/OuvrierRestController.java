package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.Ouvrier;
import com.example.SuperTissu.Service.OuvrierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ouvriers")
@CrossOrigin("*")
public class OuvrierRestController {

    @Autowired
    private OuvrierService ouvrierService;

    @PostMapping
    public ResponseEntity<Ouvrier> ajouterOuvrier(
            @RequestBody Ouvrier ouvrier) {
        return new ResponseEntity<>(
                ouvrierService.ajouterOuvrier(ouvrier),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ouvrier> modifierOuvrier(
            @PathVariable Long id,
            @RequestBody Ouvrier ouvrier) {
        ouvrier.setIdOuvrier(id);
        return ResponseEntity.ok(
                ouvrierService.modifierOuvrier(ouvrier)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerOuvrier(
            @PathVariable Long id) {
        ouvrierService.supprimerOuvrier(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ouvrier> getOuvrierById(
            @PathVariable Long id) {
        return ouvrierService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Ouvrier>> getAllOuvriers(){
        return ResponseEntity.ok(
                ouvrierService.findAll()
        );
    }

    @PutMapping("/{id}/avance")
    public ResponseEntity<Ouvrier> ajouterAvance(
            @PathVariable Long id,
            @RequestBody Double montant){
        return ResponseEntity.ok(
                ouvrierService.ajouterAvanceSalaire(id, montant)
        );
    }

    @PutMapping("/{id}/heures")
    public ResponseEntity<Ouvrier> ajouterHeures(
            @PathVariable Long id,
            @RequestBody Integer nombreHeure){
        return ResponseEntity.ok(
                ouvrierService.ajouterHeureSupplementaire(id, nombreHeure)
        );
    }

    @GetMapping("/{id}/salaire")
    public ResponseEntity<Double> calculerSalaire(@PathVariable Long id) {

        Double salaire = ouvrierService.calculerSalaire(id);

        return ResponseEntity.ok(salaire);
    }
}