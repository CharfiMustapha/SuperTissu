package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.Graffe;
import com.example.SuperTissu.Service.GraffeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/graffes")
@CrossOrigin("*")
public class GraffeRestController {
    @Autowired
    private GraffeService graffeService;

    @PostMapping
    public ResponseEntity<Graffe> ajouterGraffe(@RequestBody Graffe graffe) {
        Graffe savedGraffe = graffeService.ajouterGraffe(graffe);
        return new ResponseEntity<>(savedGraffe, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Graffe> modifierGraffe(
            @PathVariable Long id,
            @RequestBody Graffe graffe) {
        graffe.setIdProduit(id);
        Graffe updated = graffeService.modifierGraffe(graffe);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerGraffe(
            @PathVariable Long id) {
        graffeService.supprimerGraffe(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Graffe> getGraffeById(
            @PathVariable Long id) {
        return graffeService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Graffe>> getAllGraffes() {
        return ResponseEntity.ok(graffeService.findAll());
    }
}