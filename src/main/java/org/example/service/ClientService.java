package org.example.service;

import org.example.model.Client;
import org.example.repository.ClientDB;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    private final ClientDB clientRepository;

    public ClientService(ClientDB clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, Client client) {
        Optional<Client> existingClientOptional = Optional.ofNullable(clientRepository.findById(id));
        if (existingClientOptional.isPresent()) {
            Client existingClient = existingClientOptional.get();
            existingClient.setId(id);
            existingClient.setDni(client.getDni());
            existingClient.setName(client.getName());
            existingClient.setAddress(client.getAddress());
            existingClient.setEmail(client.getEmail());
            existingClient.setPhoneNumber(client.getPhoneNumber());
            existingClient.setPrimaryBranch(client.getPrimaryBranch());
            existingClient.setAccounts(client.getAccounts());
            return clientRepository.save(existingClient);
        } else {
            throw new RuntimeException("Client not found with id: " + id);
        }
    }

    @Override
    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Long id) {
        return Optional.ofNullable(clientRepository.findById(id));
    }

    @Override
    public Optional<Client> getClientByDni(String dni) {
        return clientRepository.findByDni(dni);
    }

    @Override
    public Optional<Client> getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }
}
