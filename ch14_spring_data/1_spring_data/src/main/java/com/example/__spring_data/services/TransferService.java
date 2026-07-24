package com.example.__spring_data.services;

import com.example.__spring_data.entities.Account;
import com.example.__spring_data.entities.dto.TransferDto;
import com.example.__spring_data.exceptions.AccountNotFoundException;
import com.example.__spring_data.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.nio.channels.AcceptPendingException;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    @Autowired
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(TransferDto  transferDto) {
        // get the sender and receiver account details.
        Integer senderId = transferDto.getIdSender();
        Integer receiverId = transferDto.getIdReceiver();

        if (senderId.equals(receiverId)) {
            throw new IllegalArgumentException(("You cannot send money to yourself."));
        }

        // using orElseThrow automatically unwraps the Optional type.
        Account sender = accountRepository.findById(senderId)
                .orElseThrow(() -> new AccountNotFoundException("Account with id: " + senderId + "does not exist"));

        Account receiver = accountRepository.findById(receiverId)
                .orElseThrow(() -> new AccountNotFoundException("Account with id: " + receiverId + "does not exist"));

        BigDecimal newSenderAmount = sender.getAmount().subtract(transferDto.getAmount());
        BigDecimal newReceiverAmount = receiver.getAmount().add(transferDto.getAmount());

        // adjust the account sizes.
        accountRepository.updateAmount(senderId, newSenderAmount);
        accountRepository.updateAmount(receiverId, newReceiverAmount);
    }

    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    public List<Account> findAccountsByName(String name) {
        return accountRepository.findByName(name);
    }
}
