package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Mousse;
import com.example.SuperTissu.Repository.MousseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MousseServiceImpl implements MousseService {

    @Autowired
    private MousseRepository mousseRepository;

    @Override
    public Mousse ajouterMousse(Mousse mousse) {

        mousse.setTypeProduit("MOUSSE");

        // Exemple : Mousse 5cm
        mousse.setDesignation("Mousse " + mousse.getEpaisseur() + "cm");

        return mousseRepository.save(mousse);
    }

    @Override
    public Mousse modifierMousse(Mousse mousse) {

        if (mousseRepository.existsById(mousse.getIdProduit())) {
            return mousseRepository.save(mousse);
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Mousse non trouvée avec l'id : " + mousse.getIdProduit()
        );
    }

    @Override
    public void supprimerMousse(Long id) {

        if (mousseRepository.existsById(id)) {
            mousseRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Mousse non trouvée avec l'id : " + id
            );
        }
    }

    @Override
    public Optional<Mousse> findById(Long id) {
        return mousseRepository.findById(id);
    }

    @Override
    public List<Mousse> findAll() {
        return mousseRepository.findAll();
    }
}