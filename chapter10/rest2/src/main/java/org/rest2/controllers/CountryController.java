package org.rest2.controllers;

import org.rest2.models.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {
    @GetMapping("/all")
    public ResponseEntity<Country> france() {
        Country c = Country.of("France", 123);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Paris")
                .header("favourite_food", "cheese and wine")
                .body(c);
    }
}
