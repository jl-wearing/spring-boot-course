package com.example.__transactions.services;

import com.example.__transactions.exceptions.*;
import com.example.__transactions.models.Account;
import com.example.__transactions.models.TransferDto;
import com.example.__transactions.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void addNewAccount(Account account) {
        // first determine if the account already exists.
        Optional<Account> data = accountRepository.getAccountById(account.getId());
        if (data.isPresent()) {
            throw new AccountAlreadyExistsException("Account with id " + account.getId() + " already exists");
        }

        accountRepository.addAccount(account);
    }

    public Account getAccountById(String id) throws AccountNotFoundException {
        Optional<Account> account = accountRepository.getAccountById(id);
        if (account.isPresent()) {
            return account.get();
        }
        throw new AccountNotFoundException("Account not found with id " + id);
    }

    @Transactional
    public void transferCash(TransferDto transferDto) {
        String senderID = transferDto.sender();
        String receiverID = transferDto.receiver();

        // determine if the specified account numbers exist.
        Optional<Account> sender = accountRepository.getAccountById(senderID);
        Optional<Account> receiver = accountRepository.getAccountById(receiverID);

        if (sender.isEmpty())
            throw new AccountNotFoundException("Account not found with id " + senderID);
        if (receiver.isEmpty())
            throw new AccountNotFoundException("Account not found with id " + receiverID);
        if (sender.get().getBalance().compareTo(transferDto.amount()) < 0)
            throw new NotEnoughMoneyException("Not enough money to make transfer");
        if (sender.get().getId().equals(receiver.get().getId()))
            throw new IllegalArgumentException("You cannot send money to yourself");

        // transfer the money between the accounts.
        BigDecimal newSenderAmount = sender.get().getBalance().subtract(transferDto.amount());
        BigDecimal newReceiverAmount = receiver.get().getBalance().add(transferDto.amount());

        // update the respective account balances.
        accountRepository.updateBalance(senderID, newSenderAmount);
        accountRepository.updateBalance(receiverID, newReceiverAmount);
    }

    public List<Account> findAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
