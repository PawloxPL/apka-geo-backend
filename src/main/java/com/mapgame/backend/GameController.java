package com.mapgame.backend;

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