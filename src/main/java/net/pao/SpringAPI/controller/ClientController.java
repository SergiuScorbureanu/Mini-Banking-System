package net.pao.SpringAPI.controller;

import lombok.RequiredArgsConstructor;
import net.pao.SpringAPI.model.Client;
import net.pao.SpringAPI.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/mini-banking-system/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @GetMapping
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @GetMapping(path = "/client-id/{id}")
    public Optional<Client> getClientById(@PathVariable(name = "id") UUID id) {
        return clientService.getClientById(id);
    }

    @PostMapping
    public void createClient(@RequestBody Client newClient) {
        clientService.createClient(newClient);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateClient(@PathVariable UUID id, @RequestBody Client updatedClient) {
        try {
            clientService.updateClient(id, updatedClient);
            return ResponseEntity.ok("Clientul a fost actualizat cu suuces.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<String> updateClientBySomeFields(@PathVariable UUID id, @RequestBody Client updatedClient) {
        try {
            clientService.updateClientBySomeFields(id, updatedClient);
            return ResponseEntity.ok("Clientul a fost actualizat cu succes.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable UUID id) {
        try {
            clientService.deleteClient(id);
            return ResponseEntity.ok("Clientul a fost sters cu succes.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}