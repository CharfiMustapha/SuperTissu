package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Accoudoir;
import com.example.SuperTissu.Repository.AccoudoirRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccoudoirServiceImpl implements AccoudoirService {

    @Autowired
    private AccoudoirRepository accoudoirRepository;

    @Override
    public Accoudoir ajouterAccoudoir(Accoudoir accoudoir) {

        accoudoir.setTypeProduit("ACCOUDOIR");

        // Exemple : Accoudoir Carré
        accoudoir.setDesignation("Accoudoir " + accoudoir.getForme());

        return accoudoirRepository.save(accoudoir);
    }

    @Override
    public Accoudoir modifierAccoudoir(Accoudoir accoudoir) {

        if (accoudoirRepository.existsById(accoudoir.getIdProduit())) {
            return accoudoirRepository.save(accoudoir);
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Accoudoir non trouvé avec l'id : " + accoudoir.getIdProduit()
        );
    }

    @Override
    public void supprimerAccoudoir(Long id) {

        if (accoudoirRepository.existsById(id)) {
            accoudoirRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Accoudoir non trouvé avec l'id : " + id
            );
        }
    }

    @Override
    public Optional<Accoudoir> findById(Long id) {
        return accoudoirRepository.findById(id);
    }

    @Override
    public List<Accoudoir> findAll() {
        return accoudoirRepository.findAll();
    }
}