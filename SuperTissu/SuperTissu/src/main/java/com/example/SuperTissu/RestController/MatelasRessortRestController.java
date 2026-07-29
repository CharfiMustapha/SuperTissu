package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.MatelasRessort;
import com.example.SuperTissu.Service.MatelasRessortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matelas-ressort")
@CrossOrigin("*")
public class MatelasRessortRestController {

    @Autowired
    private MatelasRessortService matelasRessortService;

    @PostMapping
    public ResponseEntity<MatelasRessort> ajouterMatelasRessort(@RequestBody MatelasRessort matelasRessort) {
        MatelasRessort saved = matelasRessortService.ajouterMatelasRessort(matelasRessort);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatelasRessort> modifierMatelasRessort(
            @PathVariable Long id,
            @RequestBody MatelasRessort matelasRessort) {
        matelasRessort.setIdProduit(id);
        MatelasRessort updated = matelasRessortService.modifierMatelasRessort(matelasRessort);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMatelasRessort(@PathVariable Long id) {
        matelasRessortService.supprimerMatelasRessort(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatelasRessort> getMatelasRessortById(@PathVariable Long id) {
        return matelasRessortService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MatelasRessort>> getAllMatelasRessort() {
        return ResponseEntity.ok(matelasRessortService.findAll());
    }
}