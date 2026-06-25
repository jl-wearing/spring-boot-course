package org.restrecap.controllers;

import org.restrecap.models.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/france")
    public Country france() {
        // Data Transfer Object DTO
        return Country.of("France", 10_000_000);
    }

    @GetMapping("/all")
    public List<Country> all() {
        Country france = Country.of("France", 10_000_000);
        Country botswana = Country.of("Botswana", 2_000_000);
        return List.of(france, botswana);
    }

    @GetMapping("/botswana")
    public ResponseEntity<Country> botswana() {
        Country botswana = Country.of("Botswana", 2_000_000);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("capital", "Gaborone")
                .header("continent", "Africa")
                .header("favourite_food", "beef")
                .body(botswana);
    }
}
