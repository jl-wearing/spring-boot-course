package com.example.__spring_data.controllers;

import com.example.__spring_data.entities.Account;
import com.example.__spring_data.entities.dto.TransferDto;
import com.example.__spring_data.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {
    private final TransferService transferService;

    @Autowired
    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Map<String, String>> transferMoney(@RequestBody TransferDto transferDto) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Transfer Successful");

        transferService.transferMoney(transferDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/accounts")
    public ResponseEntity<Iterable<Account>> findAllAccounts(@RequestParam(required = false) String name) {
        if (name == null) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(transferService.findAll());
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(transferService.findAccountsByName(name));
    }
}
