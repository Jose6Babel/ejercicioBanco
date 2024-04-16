package org.example.service;

import org.example.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    Client createClient(Client client);
    Client updateClient(Long id, Client client);
    void deleteClient(Long id);
    List<Client> getAllClients();
    Optional<Client> getClientById(Long id);
    Optional<Client> getClientByDni(String dni);
    Optional<Client> getClientByEmail(String email);
}
