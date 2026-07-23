package com.example.__transactions.services;

import com.example.__transactions.exceptions.*;
import com.example.__transactions.models.Account;
import com.example.__transactions.models.TransferDto;
import com.example.__transactions.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
        if (sender.isPresent() && receiver.isPresent()) {
            // transfer the cash between the two accounts.
            if (sender.get().getBalance().compareTo(transferDto.amount()) >= 0) {
                // subtract from the sender and add to the receiver.
                BigDecimal newSenderBalance = sender.get().getBalance().subtract(transferDto.amount());
                BigDecimal newReceiverBalance = receiver.get().getBalance().add(transferDto.amount());

                accountRepository.updateBalance(senderID, newSenderBalance);
                accountRepository.updateBalance(receiverID, newReceiverBalance);
            }
        }
    }
}
