package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.MatelasMousse;
import com.example.SuperTissu.Service.MatelasMousseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/matelas-mousse")
@CrossOrigin("*")
public class MatelasMousseRestController {

    @Autowired
    private MatelasMousseService matelasMousseService;

    @PostMapping
    public ResponseEntity<MatelasMousse> ajouterMatelasMousse(@RequestBody MatelasMousse matelasMousse) {
        MatelasMousse saved = matelasMousseService.ajouterMatelasMousse(matelasMousse);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MatelasMousse> modifierMatelasMousse(
            @PathVariable Long id,
            @RequestBody MatelasMousse matelasMousse) {
        matelasMousse.setIdProduit(id);
        MatelasMousse updated = matelasMousseService.modifierMatelasMousse(matelasMousse);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerMatelasMousse(@PathVariable Long id) {
        matelasMousseService.supprimerMatelasMousse(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatelasMousse> getMatelasMousseById(@PathVariable Long id) {
        return matelasMousseService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<MatelasMousse>> getAllMatelasMousse() {
        return ResponseEntity.ok(matelasMousseService.findAll());
    }
}