package org.rest1.controllers;

import org.rest1.models.Country;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    @GetMapping("/france")
    public Country france() {
        return Country.of("France", 67);
    }

    @GetMapping("/all")
    public List<Country> all() {
        Country c1 = Country.of("Botswana", 2_000_000);
        Country c2 = Country.of("South Africa", 50_000_000);

        return List.of(c1, c2);
    }
}
