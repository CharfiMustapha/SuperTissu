package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.Tissu;
import com.example.SuperTissu.Service.TissuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tissus")
@CrossOrigin("*")
public class TissuRestController {

    @Autowired
    private TissuService tissuService;


    @PostMapping
    public ResponseEntity<Tissu> ajouterTissu(@RequestBody Tissu tissu) {

        Tissu savedTissu = tissuService.ajouterTissu(tissu);

        return new ResponseEntity<>(savedTissu, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Tissu> modifierTissu(
            @PathVariable Long id,
            @RequestBody Tissu tissu) {

        tissu.setIdProduit(id);

        Tissu updatedTissu = tissuService.modifierTissu(tissu);

        return ResponseEntity.ok(updatedTissu);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerTissu(@PathVariable Long id) {

        tissuService.supprimerTissu(id);

        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Tissu> getTissuById(@PathVariable Long id) {

        return tissuService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping
    public ResponseEntity<List<Tissu>> getAllTissus() {

        return ResponseEntity.ok(tissuService.findAll());
    }
}