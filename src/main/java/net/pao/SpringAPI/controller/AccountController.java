package net.pao.SpringAPI.controller;

import lombok.RequiredArgsConstructor;
import net.pao.SpringAPI.model.Account;
import net.pao.SpringAPI.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/mini-banking-system/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping(path = "/account-id/{id}")
    public Optional<Account> getAccountById(@PathVariable UUID id) {
        return accountService.getAccountById(id);
    }

    @PostMapping
    public void createAccount(@RequestBody Account newAccount) {
        accountService.createAccount(newAccount);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<String> updateAccount(@PathVariable UUID id, @RequestBody Account updatedAccount) {
        try {
            accountService.updateAccount(id, updatedAccount);
            return ResponseEntity.ok("Contul a fost actualizat cu suuces.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<String> updateAccountBySomeFields(@PathVariable UUID id, @RequestBody Account updatedAccount) {
        try {
            accountService.updateAccountBySomeFields(id, updatedAccount);
            return ResponseEntity.ok("Contul a fost actualizat cu succes.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable UUID id) {
        try {
            accountService.deleteAccount(id);
            return ResponseEntity.ok("Contul a fost sters cu succes.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }
}