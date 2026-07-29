package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Client;
import com.example.SuperTissu.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client ajouterClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client modifierClient(Client client) {
        if(clientRepository.existsById(client.getIdClient())) {
            return clientRepository.save(client);
        }
        throw new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Client non trouvé avec l'id : " + client.getIdClient()
        );
    }

    @Override
    public void supprimerClient(Long id) {
        if(clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Client non trouvé avec l'id : " + id
            );
        }
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}