package net.pao.SpringAPI.service;

import lombok.RequiredArgsConstructor;
import net.pao.SpringAPI.model.Account;
import net.pao.SpringAPI.model.Client;
import net.pao.SpringAPI.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(UUID id) {
        return accountRepository.findById(id);
    }

    public void createAccount(Account newAccount) {
        accountRepository.save(newAccount);
    }

    public void updateAccount(UUID id, Account updatedAccount) {
        Optional<Account> optionalAccount = accountRepository.findById(id);

        if(optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setBalance(updatedAccount.getBalance());
            account.setAlias(updatedAccount.getAlias());
            account.setAccountNumber(updatedAccount.getAccountNumber());
            account.setAccountType(updatedAccount.getAccountType());
            accountRepository.save(account);

        } else {
            throw new NoSuchElementException("Contul cu id-ul: " + id + " nu exista in baza de date.");
        }
    }

    public void deleteAccount(UUID id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            accountRepository.delete(account);
        } else {
            throw new NoSuchElementException("Contul cu id-ul: " + id + " nu exista in baza de date.");
        }
    }

    public void updateAccountBySomeFields(UUID id, Account updatedAccount) {

        Optional<Account> optionalAccount = accountRepository.findById(id);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();

            if (updatedAccount.getBalance() != null) {
                account.setBalance(updatedAccount.getBalance());
            }

            if (updatedAccount.getAlias() != null) {
                account.setAlias(updatedAccount.getAlias());
            }

            if (updatedAccount.getAccountType() != null) {
                account.setAccountType(updatedAccount.getAccountType());
            }

            if (updatedAccount.getAccountNumber() != null) {
                account.setAccountNumber(updatedAccount.getAccountNumber());
            }

            accountRepository.save(account);
        } else {
            throw new NoSuchElementException("Accountul cu id-ul: " + id + " nu există în baza de date.");
        }
    }

}
