package com.example.SuperTissu.Service;

import com.example.SuperTissu.Entity.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    Client ajouterClient(Client client);
    Client modifierClient(Client client);
    void supprimerClient(Long id);
    Optional<Client> findById(Long id);
    List<Client> findAll();

}