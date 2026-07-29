package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.Sabot;
import com.example.SuperTissu.Service.SabotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sabots")
@CrossOrigin("*")
public class SabotRestController {

    @Autowired
    private SabotService sabotService;

    @PostMapping
    public ResponseEntity<Sabot> ajouterSabot(@RequestBody Sabot sabot) {
        Sabot saved = sabotService.ajouterSabot(sabot);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sabot> modifierSabot(
            @PathVariable Long id,
            @RequestBody Sabot sabot) {
        sabot.setIdProduit(id);
        Sabot updated = sabotService.modifierSabot(sabot);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerSabot(@PathVariable Long id) {
        sabotService.supprimerSabot(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sabot> getSabotById(@PathVariable Long id) {
        return sabotService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Sabot>> getAllSabots() {
        return ResponseEntity.ok(sabotService.findAll());
    }
}