package com.example.backPharm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.backPharm.model.Client;
import com.example.backPharm.service.ClientService;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Endpoint pour récupérer tous les clients
    @GetMapping
    public List<Client> getAllClients() {
        return clientService.findAll();
    }

    // Endpoint pour récupérer un client par ID
    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Integer id) {
        return clientService.findById(id);
    }

    // Endpoint pour ajouter un nouveau client
    @PostMapping
    public Client addClient(@RequestBody Client client) {
        return clientService.save(client);
    }

    // Endpoint pour supprimer un client
    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
    }
}