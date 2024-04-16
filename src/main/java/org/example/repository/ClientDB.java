package org.example.repository;

import org.example.model.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientDB implements IClientDB {
    private final List<Client> clients = new ArrayList<>();

    @Override
    public Client save(Client client) {
        clients.add(client);
        return client;
    }

    @Override
    public List<Client> findAll() {
        return clients;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clients.stream()
                .filter(client -> client.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        clients.removeIf(client -> client.getId().equals(id));
    }

    @Override
    public Optional<Client> findByDni(String dni) {
        return clients.stream()
                .filter(client -> client.getDni().equals(dni))
                .findFirst();
    }

    @Override
    public Optional<Client> findByEmail(String email) {
        return clients.stream()
                .filter(client -> client.getEmail().equals(email))
                .findFirst();
    }
}
