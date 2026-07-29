package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Dos;
import com.example.SuperTissu.Repository.DosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DosServiceImpl implements DosService {

    @Autowired
    private DosRepository dosRepository;

    @Override
    public Dos ajouterDos(Dos dos) {

        dos.setTypeProduit("DOS");

        // Exemple : Dos 80
        dos.setDesignation("Dos " + dos.getHauteur());

        return dosRepository.save(dos);
    }

    @Override
    public Dos modifierDos(Dos dos) {

        if (dosRepository.existsById(dos.getIdProduit())) {
            return dosRepository.save(dos);
        }

        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Dos non trouvé avec l'id : " + dos.getIdProduit()
        );
    }

    @Override
    public void supprimerDos(Long id) {

        if (dosRepository.existsById(id)) {
            dosRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Dos non trouvé avec l'id : " + id
            );
        }
    }

    @Override
    public Optional<Dos> findById(Long id) {
        return dosRepository.findById(id);
    }

    @Override
    public List<Dos> findAll() {
        return dosRepository.findAll();
    }
}