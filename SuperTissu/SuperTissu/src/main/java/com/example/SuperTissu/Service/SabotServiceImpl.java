package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Sabot;
import com.example.SuperTissu.Repository.SabotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SabotServiceImpl implements SabotService {

    @Autowired
    private SabotRepository sabotRepository;

    @Override
    public Sabot ajouterSabot(Sabot sabot) {

        sabot.setTypeProduit("SABOT");

        // Exemple : Sabot Premium Noir
        sabot.setDesignation(
                "Sabot " +
                sabot.getGamme() + " " +
                sabot.getCouleur()
        );

        return sabotRepository.save(sabot);
    }

    @Override
    public Sabot modifierSabot(Sabot sabot) {

        if (sabotRepository.existsById(sabot.getIdProduit())) {
            return sabotRepository.save(sabot);
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Sabot non trouvé avec l'id : " + sabot.getIdProduit()
        );
    }

    @Override
    public void supprimerSabot(Long id) {

        if (sabotRepository.existsById(id)) {
            sabotRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Sabot non trouvé avec l'id : " + id
            );
        }
    }

    @Override
    public Optional<Sabot> findById(Long id) {
        return sabotRepository.findById(id);
    }

    @Override
    public List<Sabot> findAll() {
        return sabotRepository.findAll();
    }
}