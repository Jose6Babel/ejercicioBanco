package org.example.repository;

import org.example.model.Client;

import java.util.List;
import java.util.Optional;

public interface IClientDB {
    Client save(Client client);
    List<Client> findAll();
    Optional<Client> findById(Long id);
    void deleteById(Long id);
    Optional<Client> findByDni(String dni);
    Optional<Client> findByEmail(String email);
}
