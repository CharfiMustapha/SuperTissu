package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Ouvrier;
import com.example.SuperTissu.Repository.OuvrierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OuvrierServiceImpl implements OuvrierService {

    @Autowired
    private OuvrierRepository ouvrierRepository;

    @Override
    public Ouvrier ajouterOuvrier(Ouvrier ouvrier) {
        if(ouvrier.getAvanceSalaire() == null)
            ouvrier.setAvanceSalaire(0.0);
        if(ouvrier.getNombreHeureSupplementaire() == null)
            ouvrier.setNombreHeureSupplementaire(0);
        return ouvrierRepository.save(ouvrier);
    }

    @Override
    public Ouvrier modifierOuvrier(Ouvrier ouvrier) {
        if(ouvrierRepository.existsById(ouvrier.getIdOuvrier())) {
            return ouvrierRepository.save(ouvrier);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Ouvrier non trouvé avec l'id : "
                        + ouvrier.getIdOuvrier()
        );
    }

    @Override
    public void supprimerOuvrier(Long id) {
        if(ouvrierRepository.existsById(id)) {
            ouvrierRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Ouvrier non trouvé avec l'id : " + id
            );
        }
    }

    @Override
    public Optional<Ouvrier> findById(Long id) {
        return ouvrierRepository.findById(id);
    }

    @Override
    public List<Ouvrier> findAll() {
        return ouvrierRepository.findAll();
    }

    @Override
    public Ouvrier ajouterAvanceSalaire(Long id, Double montant) {
        Ouvrier ouvrier = ouvrierRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Ouvrier non trouvé"
                        )
                );
        ouvrier.setAvanceSalaire(
                ouvrier.getAvanceSalaire() + montant
        );
        return ouvrierRepository.save(ouvrier);
    }

    @Override
    public Ouvrier ajouterHeureSupplementaire(Long id, Integer nombreHeure) {
        Ouvrier ouvrier = ouvrierRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Ouvrier non trouvé"
                        )
                );
        ouvrier.setNombreHeureSupplementaire(
                ouvrier.getNombreHeureSupplementaire()
                        + nombreHeure
        );
        return ouvrierRepository.save(ouvrier);
    }

    @Override
    public Double calculerSalaire(Long idOuvrier) {

        Ouvrier ouvrier = ouvrierRepository.findById(idOuvrier)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Ouvrier non trouvé avec l'id: " + idOuvrier
                ));

        Double salaireFinal = ouvrier.getSalaire();

        if (ouvrier.getNombreHeureSupplementaire() != null
                && ouvrier.getPrixHeureSupplementaire() != null) {

            salaireFinal += ouvrier.getNombreHeureSupplementaire()
                    * ouvrier.getPrixHeureSupplementaire();
        }

        if (ouvrier.getAvanceSalaire() != null) {
            salaireFinal -= ouvrier.getAvanceSalaire();
        }

        return salaireFinal;
    }
}