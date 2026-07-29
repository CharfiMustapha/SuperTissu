package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Salon;
import com.example.SuperTissu.Repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SalonServiceImpl implements SalonService {

    @Autowired
    private SalonRepository salonRepository;

    @Override
    public Salon ajouterSalon(Salon salon) {
        return salonRepository.save(salon);
    }

    @Override
    public Salon modifierSalon(Salon salon) {
        if (salonRepository.existsById(salon.getIdSalon())) {
            return salonRepository.save(salon);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Salon non trouvé avec l'id : " + salon.getIdSalon()
        );
    }

    @Override
    public void supprimerSalon(Long id) {
        if (salonRepository.existsById(id)) {
            salonRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Salon non trouvé avec l'id : " + id
            );
        }
    }

    @Override
    public Optional<Salon> findById(Long id) {
        return salonRepository.findById(id);
    }

    @Override
    public List<Salon> findAll() {
        return salonRepository.findAll();
    }

    @Override
    public List<Salon> findByNomSalon(String nomSalon) {
        return salonRepository.findByNomSalon(nomSalon);
    }
}