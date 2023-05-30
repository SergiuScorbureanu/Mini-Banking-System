package net.pao.SpringAPI.service;

import lombok.RequiredArgsConstructor;
import net.pao.SpringAPI.model.Client;
import net.pao.SpringAPI.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(UUID id) {
        return clientRepository.findById(id);
    }

    public void createClient(Client newClient) {
        clientRepository.save(newClient);
    }

    public void updateClient(UUID id, Client updatedClient) {

        Optional<Client> optionalClient = clientRepository.findById(id);

        if(optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.setLastName(updatedClient.getLastName());
            client.setFirstName(updatedClient.getFirstName());
            client.setBirthDay(updatedClient.getBirthDay());
            client.setAddress(updatedClient.getAddress());
            client.setEmail(updatedClient.getEmail());
            clientRepository.save(client);

        } else {
            throw new NoSuchElementException("Clientul cu id-ul: " + id + " nu exista in baza de date.");
        }
    }

    public void deleteClient(UUID id) {
        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            clientRepository.delete(client);
        } else {
            throw new NoSuchElementException("Clientul cu id-ul: " + id + " nu exista in baza de date.");
        }
     }

    public void updateClientBySomeFields(UUID id, Client updatedClient) {

        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();

            if (updatedClient.getFirstName() != null) {
                client.setFirstName(updatedClient.getFirstName());
            }

            if (updatedClient.getLastName() != null) {
                client.setLastName(updatedClient.getLastName());
            }

            if (updatedClient.getAddress() != null) {
                client.setAddress(updatedClient.getAddress());
            }

            if (updatedClient.getEmail() != null) {
                client.setEmail(updatedClient.getEmail());
            }

            clientRepository.save(client);
        } else {
            throw new NoSuchElementException("Clientul cu id-ul: " + id + " nu există în baza de date.");
        }
    }
}
