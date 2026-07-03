package org.example.__response_entity.controllers;

import org.example.__response_entity.models.Country;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @GetMapping("/france")
    public ResponseEntity<Country> france() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("continent", "Europe")
                .header("capital", "Paris")
                .header("favourite_food", "wine")
                .body(new Country("France", 67));
    }
}
