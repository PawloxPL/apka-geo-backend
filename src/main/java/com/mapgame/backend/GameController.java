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

    @GetMapping("/quiz-data")
    public List<Country> getQuizData() {
        List<Country> countries = new ArrayList<>();
        // countries.add(new Country("Polska", "PL", "Warszawa"));
        // countries.add(new Country("Niemcy", "DE", "Berlin"));
        // countries.add(new Country("Francja", "FR", "Paryż"));
        // countries.add(new Country("Włochy", "IT", "Rzym"));
        // countries.add(new Country("Hiszpania", "ES", "Madryt"));
        // countries.add(new Country("Portugalia", "PT", "Lizbona"));
        // countries.add(new Country("Wielka Brytania", "GB", "Londyn"));
        // countries.add(new Country("Holandia", "NL", "Amsterdam"));
        
        // --- Europa Północna (Skandynawia i Bałtyki) ---
        countries.add(new Country("Szwecja", "SE", "Sztokholm"));
        countries.add(new Country("Norwegia", "NO", "Oslo"));
        countries.add(new Country("Dania", "DK", "Kopenhaga"));
        countries.add(new Country("Finlandia", "FI", "Helsinki"));
        countries.add(new Country("Islandia", "IS", "Reykjavik"));
        countries.add(new Country("Litwa", "LT", "Wilno"));
        countries.add(new Country("Łotwa", "LV", "Ryga"));
        countries.add(new Country("Estonia", "EE", "Tallinn"));

        // --- Europa Zachodnia i Centralna ---
        countries.add(new Country("Irlandia", "IE", "Dublin"));
        countries.add(new Country("Belgia", "BE", "Bruksela"));
        countries.add(new Country("Szwajcaria", "CH", "Berno"));
        countries.add(new Country("Austria", "AT", "Wiedeń"));
        countries.add(new Country("Czechy", "CZ", "Praga"));
        countries.add(new Country("Słowacja", "SK", "Bratysława"));
        countries.add(new Country("Węgry", "HU", "Budapeszt"));

        // --- Europa Wschodnia ---
        countries.add(new Country("Ukraina", "UA", "Kijów"));
        countries.add(new Country("Białoruś", "BY", "Mińsk"));
        countries.add(new Country("Rumunia", "RO", "Bukareszt"));
        countries.add(new Country("Bułgaria", "BG", "Sofia"));
        countries.add(new Country("Mołdawia", "MD", "Kiszyniów"));

        // --- Bałkany i Południe ---
        countries.add(new Country("Grecja", "GR", "Ateny"));
        countries.add(new Country("Chorwacja", "HR", "Zagrzeb"));
        countries.add(new Country("Serbia", "RS", "Belgrad"));
        countries.add(new Country("Bośnia i Hercegowina", "BA", "Sarajewo"));
        countries.add(new Country("Albania", "AL", "Tirana"));
        countries.add(new Country("Macedonia Północna", "MK", "Skopje"));
        countries.add(new Country("Czarnogóra", "ME", "Podgorica"));
        countries.add(new Country("Słowenia", "SI", "Lublana"));
        countries.add(new Country("Turcja", "TR", "Ankara")); // Często wliczana w quizach
        countries.add(new Country("Cypr", "CY", "Nikozja"));

        // --- Mikropaństwa (Opcjonalne - dla trudniejszych pytań) ---
        countries.add(new Country("Malta", "MT", "Valletta"));
        countries.add(new Country("Luksemburg", "LU", "Luksemburg"));
        countries.add(new Country("Monako", "MC", "Monako"));
        
        Collections.shuffle(countries);
        
        return countries;
    }
}