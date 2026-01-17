package com.mapgame.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.ArrayList;

class Country {
    public String name;
    public String code;

    public Country(String name, String code) {
        this.name = name;
        this.code = code;
    }
}

@RestController
@RequestMapping("/api/game")
public class GameController {

    @GetMapping("/countries")
    public List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Polska", "PL"));
        countries.add(new Country("Niemcy", "DE"));
        countries.add(new Country("Francja", "FR"));
        countries.add(new Country("Włochy", "IT"));
        
        return countries;
    }
}