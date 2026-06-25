package org.transaction.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.transaction.models.Account;
import org.transaction.repositories.AccountRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    @Autowired
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(long idSender, long idReceiver, BigDecimal amount) throws RuntimeException {
        // Find the account sending money.
        Account sender = accountRepository.findAccountById(idSender);

        // Find the account receiving money.
        Account receiver = accountRepository.findAccountById(idReceiver);

        // Deduct from sender, add to receiver.
        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        if (senderNewAmount.compareTo(amount) <= 0) {
            throw new RuntimeException("Amount to be withdrawn must be less than account balance size.");
        }

        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        // Transfer the money between accounts.
        accountRepository.changeAmount(idSender, senderNewAmount);
        accountRepository.changeAmount(idReceiver, receiverNewAmount);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAllAccounts();
    }
}
