package com.example.__testing;

import com.example.__testing.entities.Account;
import com.example.__testing.entities.dto.TransferDto;
import com.example.__testing.exceptions.AccountNotFoundException;
import com.example.__testing.repositories.AccountRepository;
import com.example.__testing.services.AccountService;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class TransferMoneyTests {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @DisplayName("Tests that money is transferred between the 2 accounts when all required parameters are correctly" +
            "specified")
    @Test
    public void testTransferMoneyHappyFlow() {
        // Define the input to the tested method.
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal("1000.00"));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal("1000.00"));

        TransferDto dto = new TransferDto();
        dto.setSenderId(sender.getId());
        dto.setReceiverId(receiver.getId());
        dto.setAmount(new BigDecimal("100.00"));

        // Control how the dependency should behave when the tested method is called.
        given(accountRepository.findById(sender.getId()))
                .willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId()))
                .willReturn(Optional.of(receiver));

        // Call the method being tested.
        accountService.transferMoney(dto);

        // Verify the method behaved as expected.
        verify(accountRepository).updateAmount(sender.getId(), new BigDecimal("900.00"));
        verify(accountRepository).updateAmount(receiver.getId(), new BigDecimal("1100.00"));
    }

    @DisplayName("Tests that the account-not-found-exception is thrown and does not cause money to transfer"
    + " when either the sender or receiver account does not exist.")
    @Test
    public void testAccountNotFoundWhenTransferringMoney() {
        // Define the inputs to the tested method.
        Account sender = new Account();
        sender.setId(1);
        sender.setAmount(new BigDecimal("1000.00"));

        Account receiver = new Account();
        receiver.setId(2);
        receiver.setAmount(new BigDecimal("1000.00"));

        TransferDto dto = new TransferDto();
        dto.setSenderId(sender.getId());
        dto.setReceiverId(receiver.getId());
        dto.setAmount(new BigDecimal("100.00"));

        // Define how the dependencies should behave when the tested method is executed.
        given(accountRepository.findById(sender.getId()))
                .willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId()))
                .willReturn(Optional.empty());

        // Call the executed method.
        // assert that the tested method throws the correct exception.
        assertThrows(AccountNotFoundException.class,
                () -> accountService.transferMoney(dto));

        // Verify that the data remains consistent and correct.
        // Also verify this method was never called.
        verify(accountRepository, never())
                .updateAmount(anyInt(), any(BigDecimal.class));
    }
}
