package com.example.backPharm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backPharm.model.Client;
import com.example.backPharm.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    // Méthode pour récupérer tous les clients
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    // Méthode pour récupérer un client par ID
    public Optional<Client> findById(Integer id) {
        return clientRepository.findById(id);
    }

    // Méthode pour enregistrer un client
    public Client save(Client client) {
        return clientRepository.save(client);
    }

    // Méthode pour supprimer un client
    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}

