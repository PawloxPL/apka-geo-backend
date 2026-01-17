package com.mapgame.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Country {
    public String name;
    public String code;
    public String capital;

    public Country(String name, String code, String capital) {
        this.name = name;
        this.code = code;
        this.capital = capital;
    }
}

@RestController
@RequestMapping("/api/game")
public class GameController {

    @GetMapping("/quiz-data") // Zmieńmy nazwę endpointu na bardziej adekwatną
    public List<Country> getQuizData() {
        List<Country> countries = new ArrayList<>();
        // Dodaj więcej krajów, żeby losowanie miało sens!
        countries.add(new Country("Polska", "PL", "Warszawa"));
        countries.add(new Country("Niemcy", "DE", "Berlin"));
        countries.add(new Country("Francja", "FR", "Paryż"));
        countries.add(new Country("Włochy", "IT", "Rzym"));
        countries.add(new Country("Hiszpania", "ES", "Madryt"));
        countries.add(new Country("Portugalia", "PT", "Lizbona"));
        countries.add(new Country("Wielka Brytania", "GB", "Londyn"));
        countries.add(new Country("Holandia", "NL", "Amsterdam"));
        
        // Tasujemy listę na serwerze, żeby za każdym razem kolejność pytań była inna
        Collections.shuffle(countries);
        
        return countries;
    }
}