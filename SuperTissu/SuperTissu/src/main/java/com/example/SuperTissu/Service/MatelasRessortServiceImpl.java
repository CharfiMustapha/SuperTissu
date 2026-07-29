package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.MatelasRessort;
import com.example.SuperTissu.Repository.MatelasRessortRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatelasRessortServiceImpl implements MatelasRessortService {

    @Autowired
    private MatelasRessortRepository matelasRessortRepository;

    @Override
    public MatelasRessort ajouterMatelasRessort(MatelasRessort matelasRessort) {

        matelasRessort.setTypeProduit("MATELAS_RESSORT");

        // Exemple : Matelas Ressort Confort 140x190
        matelasRessort.setDesignation(
                "Matelas Ressort " +
                matelasRessort.getNom() + " " +
                matelasRessort.getLargeur() + "x" +
                matelasRessort.getLongueur()
        );

        return matelasRessortRepository.save(matelasRessort);
    }

    @Override
    public MatelasRessort modifierMatelasRessort(MatelasRessort matelasRessort) {

        if (matelasRessortRepository.existsById(matelasRessort.getIdProduit())) {
            return matelasRessortRepository.save(matelasRessort);
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Matelas Ressort non trouvé avec l'id : " + matelasRessort.getIdProduit()
        );
    }

    @Override
    public void supprimerMatelasRessort(Long id) {

        if (matelasRessortRepository.existsById(id)) {
            matelasRessortRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Matelas Ressort non trouvé avec l'id : " + id
            );
        }
    }

    @Override
    public Optional<MatelasRessort> findById(Long id) {
        return matelasRessortRepository.findById(id);
    }

    @Override
    public List<MatelasRessort> findAll() {
        return matelasRessortRepository.findAll();
    }
}