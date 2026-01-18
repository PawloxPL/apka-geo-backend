package com.mapgame.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/game")
public class GameController {

    private final CountryRepository repository;

    public GameController(CountryRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/quiz-data")
    public List<Country> getQuizData() {
        List<Country> allCountries = repository.findAll();
        Collections.shuffle(allCountries);
        return allCountries;
    }
}