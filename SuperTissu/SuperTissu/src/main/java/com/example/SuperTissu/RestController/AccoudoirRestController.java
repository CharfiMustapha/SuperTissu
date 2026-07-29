package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.Accoudoir;
import com.example.SuperTissu.Service.AccoudoirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accoudoirs")
@CrossOrigin("*")
public class AccoudoirRestController {

    @Autowired
    private AccoudoirService accoudoirService;

    @PostMapping
    public ResponseEntity<Accoudoir> ajouterAccoudoir(@RequestBody Accoudoir accoudoir) {
        Accoudoir saved = accoudoirService.ajouterAccoudoir(accoudoir);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accoudoir> modifierAccoudoir(
            @PathVariable Long id,
            @RequestBody Accoudoir accoudoir) {
        accoudoir.setIdProduit(id);
        Accoudoir updated = accoudoirService.modifierAccoudoir(accoudoir);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerAccoudoir(@PathVariable Long id) {
        accoudoirService.supprimerAccoudoir(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accoudoir> getAccoudoirById(@PathVariable Long id) {
        return accoudoirService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Accoudoir>> getAllAccoudoirs() {
        return ResponseEntity.ok(accoudoirService.findAll());
    }
}