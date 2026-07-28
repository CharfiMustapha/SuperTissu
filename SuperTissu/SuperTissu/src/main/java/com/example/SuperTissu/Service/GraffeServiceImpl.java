package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Graffe;
import com.example.SuperTissu.Repository.GraffeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GraffeServiceImpl implements GraffeService {
    @Autowired
    private GraffeRepository graffeRepository;

    @Override
    public Graffe ajouterGraffe(Graffe graffe) {
        graffe.setTypeProduit("GRAFFE");
        // Example: Graffe + 14 = Graffe 14
        graffe.setDesignation(
                "Graffe " + graffe.getTaille()
        );
        return graffeRepository.save(graffe);
    }

    @Override
    public Graffe modifierGraffe(Graffe graffe) {
        if (graffeRepository.existsById(graffe.getIdProduit())) {
            return graffeRepository.save(graffe);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Graffe non trouvé avec l'id : " + graffe.getIdProduit()
        );
    }

    @Override
    public void supprimerGraffe(Long id) {
        if (graffeRepository.existsById(id)) {
            graffeRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Graffe non trouvé avec l'id : " + id
            );
        }
    }

    @Override
    public Optional<Graffe> findById(Long id) {
        return graffeRepository.findById(id);
    }

    @Override
    public List<Graffe> findAll() {
        return graffeRepository.findAll();
    }
}