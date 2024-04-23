package org.example.service;

import org.example.model.Account;
import org.example.model.Client;
import org.example.repository.IClientDB;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    private final IClientDB clientRepository;
    private final IAccountService accountService;

    public ClientService(IClientDB clientRepository, IAccountService accountService) {
        this.clientRepository = clientRepository;
        this.accountService = accountService;
    }

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client updateClient(Long id, Client client) {
        Optional<Client> existingClientOptional = clientRepository.findById(id);
        if (existingClientOptional.isPresent()) {
            Client existingClient = existingClientOptional.get();
            updateClientData(existingClient, client);
            return clientRepository.save(existingClient);
        } else {
            throw new RuntimeException("Client not found with id: " + id);
        }
    }

    private void updateClientData(Client existingClient, Client updatedClient) {
        existingClient.setDni(updatedClient.getDni());
        existingClient.setName(updatedClient.getName());
        existingClient.setAddress(updatedClient.getAddress());
        existingClient.setEmail(updatedClient.getEmail());
        existingClient.setPhoneNumber(updatedClient.getPhoneNumber());
        existingClient.setPrimaryBranch(updatedClient.getPrimaryBranch());
        existingClient.setAccounts(updatedClient.getAccounts());
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
        return clientRepository.findById(id);
    }

    @Override
    public Optional<Client> getClientByDni(String dni) {
        return clientRepository.findByDni(dni);
    }

    @Override
    public Optional<Client> getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    @Override
    public List<Account> getClientAccounts(Long clientId) {
        Optional<Client> clientOptional = clientRepository.findById(clientId);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
            return client.getAccounts();
        } else {
            throw new RuntimeException("Client not found with id: " + clientId);
        }
    }
}
