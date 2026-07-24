package com.example.__testing.services;

import com.example.__testing.entities.Account;
import com.example.__testing.entities.dto.TransferDto;
import com.example.__testing.exceptions.AccountNotFoundException;
import com.example.__testing.exceptions.NotEnoughMoneyException;
import com.example.__testing.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(TransferDto transferDto) {
        /*
         * Things to consider:
         * - either, or both accounts do not exist
         * - the sender is attempting to send money to the same account
         * - the sender does not have enough money to make the transfer
         */
        // get the account ID's
        Integer senderId = transferDto.getSenderId();
        Integer receiverId = transferDto.getReceiverId();

        if (senderId.equals(receiverId))
            throw new IllegalArgumentException("You cannot send money to yourself.");

        // orElseThrow() unwraps the optional type
        Account sender = accountRepository.findById(senderId)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + senderId + " not found."));

        Account receiver = accountRepository.findById(receiverId)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + receiverId + " not found."));

        // determine if the sender has enough money to make the request
        if (sender.getAmount().compareTo(transferDto.getAmount()) < 0)
            throw new NotEnoughMoneyException("You do not have enough to make the transfer.");

        // make the transfer between the accounts.
        BigDecimal newSenderAmount = sender.getAmount().subtract(transferDto.getAmount());
        BigDecimal newReceiverAmount = receiver.getAmount().subtract(transferDto.getAmount());

        accountRepository.updateAmount(senderId, newSenderAmount);
        accountRepository.updateAmount(receiverId, newReceiverAmount);
    }
}
