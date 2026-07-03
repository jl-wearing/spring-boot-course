package org.example.__dtos;

import org.example.__dtos.models.Country;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @GetMapping("/france")
    public Country france() {
        return Country.builder()
                .name("France")
                .population(67)
                .build();
    }

    @GetMapping("/countries")
    public List<Country> countries() {
        return List.of(new Country("France", 67),
                new Country("Germany", 89),
                new Country("Italy", 55));
    }
}
