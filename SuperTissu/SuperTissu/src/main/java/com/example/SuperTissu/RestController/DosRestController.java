package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.Dos;
import com.example.SuperTissu.Service.DosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/dos")
@CrossOrigin("*")
public class DosRestController {

    @Autowired
    private DosService dosService;

    @PostMapping
    public ResponseEntity<Dos> ajouterDos(@RequestBody Dos dos) {
        Dos saved = dosService.ajouterDos(dos);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dos> modifierDos(
            @PathVariable Long id,
            @RequestBody Dos dos) {
        dos.setIdProduit(id);
        Dos updated = dosService.modifierDos(dos);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerDos(@PathVariable Long id) {
        dosService.supprimerDos(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dos> getDosById(@PathVariable Long id) {
        return dosService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Dos>> getAllDos() {
        return ResponseEntity.ok(dosService.findAll());
    }
}