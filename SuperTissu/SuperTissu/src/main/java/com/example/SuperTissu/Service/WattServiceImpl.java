package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Watt;
import com.example.SuperTissu.Repository.WattRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WattServiceImpl implements WattService {

    @Autowired
    private WattRepository wattRepository;

    @Override
    public Watt ajouterWatt(Watt watt) {

        watt.setTypeProduit("WATT");

        // Exemple : Watt 2.5
        watt.setDesignation("Watt " + watt.getEpaisseur());

        return wattRepository.save(watt);
    }

    @Override
    public Watt modifierWatt(Watt watt) {

        if (wattRepository.existsById(watt.getIdProduit())) {
            return wattRepository.save(watt);
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Watt non trouvé avec l'id : " + watt.getIdProduit()
        );
    }

    @Override
    public void supprimerWatt(Long id) {

        if (wattRepository.existsById(id)) {
            wattRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Watt non trouvé avec l'id : " + id
            );
        }
    }

    @Override
    public Optional<Watt> findById(Long id) {
        return wattRepository.findById(id);
    }

    @Override
    public List<Watt> findAll() {
        return wattRepository.findAll();
    }
}