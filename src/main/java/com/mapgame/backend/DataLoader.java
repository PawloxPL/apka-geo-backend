package com.mapgame.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final CountryRepository repository;

    public DataLoader(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            System.out.println("--- ŁADOWANIE BAZY DANYCH ---");
            
            repository.save(new Country("Polska", "PL", "Warszawa", "Europa Środkowa", "38 mln", "312 696 km²", List.of("Polski"), "Polska ma najdłuższą linię brzegową Morza Bałtyckiego!"));
            // ... i tak dalej dla wszystkich 40 krajów ...

            System.out.println("--- BAZA ZAŁADOWANA ---");
        }
    }
}