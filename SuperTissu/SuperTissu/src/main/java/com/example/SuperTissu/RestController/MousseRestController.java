package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.Mousse;
import com.example.SuperTissu.Service.MousseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mousses")
@CrossOrigin("*")
public class MousseRestController {

    @Autowired
    private MousseService mousseService;

    @PostMapping
    public ResponseEntity<Mousse> ajouterMousse(@RequestBody Mousse mousse) {
        Mousse saved = mousseService.ajouterMousse(mousse);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mousse> modifierMousse(
            @PathVariable Long id,
            @RequestBody Mousse mousse) {
        mousse.setIdProduit(id);
        Mousse updated = mousseService.modifierMousse(mousse);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMousse(@PathVariable Long id) {
        mousseService.supprimerMousse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mousse> getMousseById(@PathVariable Long id) {
        return mousseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Mousse>> getAllMousses() {
        return ResponseEntity.ok(mousseService.findAll());
    }
}