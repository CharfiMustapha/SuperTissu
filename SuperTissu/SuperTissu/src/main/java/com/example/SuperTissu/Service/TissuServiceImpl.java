package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Tissu;
import com.example.SuperTissu.Repository.TissuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TissuServiceImpl implements TissuService {
    @Autowired
    private TissuRepository tissuRepository;

    @Override
    public Tissu ajouterTissu(Tissu tissu) {
        // Automatically set product type
        tissu.setTypeProduit("TISSU");
        // Example: Rio + 2# = Rio 2#
        tissu.setDesignation(
                tissu.getGamme() + " " + tissu.getNumeroReference()
        );
        return tissuRepository.save(tissu);
    }

    @Override
    public Tissu modifierTissu(Tissu tissu) {
        if (tissuRepository.existsById(tissu.getIdProduit())) {
            return tissuRepository.save(tissu);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Tissu non trouvé avec l'id: " + tissu.getIdProduit()
        );
    }

    @Override
    public void supprimerTissu(Long id) {
        if (tissuRepository.existsById(id)) {
            tissuRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Tissu non trouvé avec l'id: " + id
            );
        }
    }

    @Override
    public Optional<Tissu> findById(Long id) {
        return tissuRepository.findById(id);
    }

    @Override
    public List<Tissu> findAll() {
        return tissuRepository.findAll();
    }
}