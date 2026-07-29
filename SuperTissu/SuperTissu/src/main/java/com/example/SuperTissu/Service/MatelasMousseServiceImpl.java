package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.MatelasMousse;
import com.example.SuperTissu.Repository.MatelasMousseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MatelasMousseServiceImpl implements MatelasMousseService {

    @Autowired
    private MatelasMousseRepository matelasMousseRepository;

    @Override
    public MatelasMousse ajouterMatelasMousse(MatelasMousse matelasMousse) {

        matelasMousse.setTypeProduit("MATELAS_MOUSSE");

        // Exemple : Matelas Mousse D25 10cm
        matelasMousse.setDesignation(
                "Matelas Mousse " +
                matelasMousse.getDensite() +
                " " +
                matelasMousse.getEpaisseur() + "cm"
        );

        return matelasMousseRepository.save(matelasMousse);
    }

    @Override
    public MatelasMousse modifierMatelasMousse(MatelasMousse matelasMousse) {

        if (matelasMousseRepository.existsById(matelasMousse.getIdProduit())) {
            return matelasMousseRepository.save(matelasMousse);
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Matelas Mousse non trouvé avec l'id : " + matelasMousse.getIdProduit()
        );
    }

    @Override
    public void supprimerMatelasMousse(Long id) {

        if (matelasMousseRepository.existsById(id)) {
            matelasMousseRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Matelas Mousse non trouvé avec l'id : " + id
            );
        }
    }

    @Override
    public Optional<MatelasMousse> findById(Long id) {
        return matelasMousseRepository.findById(id);
    }

    @Override
    public List<MatelasMousse> findAll() {
        return matelasMousseRepository.findAll();
    }
}