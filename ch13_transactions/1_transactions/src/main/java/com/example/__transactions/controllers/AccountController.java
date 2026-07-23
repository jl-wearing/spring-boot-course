package com.example.__transactions.controllers;

import com.example.__transactions.models.Account;
import com.example.__transactions.models.TransferDto;
import com.example.__transactions.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/")
    public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account) {
        // create an ID for the account.
        account.setId(UUID.randomUUID().toString());

        // add the new account to the database.
        accountService.addNewAccount(account);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(account);
    }

    @PatchMapping("/")
    public ResponseEntity<String> transferCash(@Valid @RequestBody TransferDto transferDto) {
        accountService.transferCash(transferDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Transfer successful");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountService.findAllAccounts());
    }
}
