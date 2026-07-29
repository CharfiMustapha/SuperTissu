package com.example.SuperTissu.RestController;

import com.example.SuperTissu.Entity.Client;
import com.example.SuperTissu.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> ajouterClient(@RequestBody Client client) {
        Client savedClient = clientService.ajouterClient(client);
        return new ResponseEntity<>(savedClient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> modifierClient(
            @PathVariable Long id,
            @RequestBody Client client) {
        client.setIdClient(id);
        Client updatedClient = clientService.modifierClient(client);
        return ResponseEntity.ok(updatedClient);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerClient(@PathVariable Long id) {

        clientService.supprimerClient(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return clientService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.findAll();
        return ResponseEntity.ok(clients);
    }
}