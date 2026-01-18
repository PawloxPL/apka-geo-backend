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
    public String region;
    public String population;
    public String area;
    public List<String> languages;
    public String funFact;

    public Country(String name, String code, String capital) {
        this.name = name;
        this.code = code;
        this.capital = capital;
    }

    public Country(String name, String code, String capital, String region, String population, String area, List<String> languages, String funFact) {
        this.name = name;
        this.code = code;
        this.capital = capital;
        this.region = region;
        this.population = population;
        this.area = area;
        this.languages = languages;
        this.funFact = funFact;
    }
}

@RestController
@RequestMapping("/api/game")
public class GameController {

    @GetMapping("/quiz-data")
    public List<Country> getQuizData() {
        List<Country> countries = new ArrayList<>();
        countries.add(new Country("Polska", "PL", "Warszawa", "Europa Środkowa", "38 mln", "312 696 km²", List.of("Polski"), "Polska ma najdłuższą linię brzegową Morza Bałtyckiego!"));
        countries.add(new Country("Niemcy", "DE", "Berlin", "Europa Środkowa", "83 mln", "357 022 km²", List.of("Niemiecki"), "Niemcy mają ponad 1500 różnych rodzajów piwa!"));
        countries.add(new Country("Francja", "FR", "Paryż", "Europa Zachodnia", "67 mln", "643 801 km²", List.of("Francuski"), "Wieża Eiffla może się wydłużyć o 15 cm w upalne dni!"));
        countries.add(new Country("Hiszpania", "ES", "Madryt", "Europa Południowa", "47 mln", "505 990 km²", List.of("Hiszpański"), "Hiszpania ma ponad 8000 km wybrzeża!"));
        countries.add(new Country("Włochy", "IT", "Rzym", "Europa Południowa", "60 mln", "301 340 km²", List.of("Włoski"), "We Włoszech znajduje się najwięcej wulkanów w Europie!"));
        countries.add(new Country("Wielka Brytania", "GB", "Londyn", "Europa Zachodnia", "67 mln", "242 495 km²", List.of("Angielski"), "W Londynie jest więcej Indian niż w jakimkolwiek innym mieście poza Indiami!"));
        countries.add(new Country("Szwecja", "SE", "Sztokholm", "Europa Północna", "10 mln", "450 295 km²", List.of("Szwedzki"), "Szwecja ma ponad 100 000 jezior!"));
        countries.add(new Country("Norwegia", "NO", "Oslo", "Europa Północna", "5 mln", "385 207 km²", List.of("Norweski"), "Norwegia ma najdłuższą linię brzegową na świecie!"));
        countries.add(new Country("Grecja", "GR", "Ateny", "Europa Południowa", "11 mln", "131 957 km²", List.of("Grecki"), "Grecja ma ponad 6000 wysp!"));
        countries.add(new Country("Portugalia", "PT", "Lizbona", "Europa Zachodnia", "10 mln", "92 090 km²", List.of("Portugalski"), "Portugalia jest najstarszym krajem w Europie z niezmienionymi granicami!"));
        countries.add(new Country("Holandia", "NL", "Amsterdam", "Europa Zachodnia", "17 mln", "41 543 km²", List.of("Holenderski"), "W Holandii jest więcej rowerów niż ludzi!"));
        countries.add(new Country("Belgia", "BE", "Bruksela", "Europa Zachodnia", "11 mln", "30 528 km²", List.of("Holenderski", "Francuski", "Niemiecki"), "Belgia produkuje 220 000 ton czekolady rocznie!"));
        countries.add(new Country("Austria", "AT", "Wiedeń", "Europa Środkowa", "9 mln", "83 871 km²", List.of("Niemiecki"), "Austria jest jednym z najbardziej zalesionych krajów w Europie!"));
        countries.add(new Country("Czechy", "CZ", "Praga", "Europa Środkowa", "11 mln", "78 867 km²", List.of("Czeski"), "Czesi piją więcej piwa na osobę niż jakikolwiek inny naród!"));
        countries.add(new Country("Dania", "DK", "Kopenhaga", "Europa Północna", "6 mln", "42 933 km²", List.of("Duński"), "Dania składa się z jednego półwyspu i 443 wysp!"));

        countries.add(new Country("Albania", "AL", "Tirana"));
        countries.add(new Country("Białoruś", "BY", "Mińsk"));
        countries.add(new Country("Bośnia i Hercegowina", "BA", "Sarajewo"));
        countries.add(new Country("Bułgaria", "BG", "Sofia"));
        countries.add(new Country("Chorwacja", "HR", "Zagrzeb"));
        countries.add(new Country("Cypr", "CY", "Nikozja"));
        countries.add(new Country("Estonia", "EE", "Tallinn"));
        countries.add(new Country("Finlandia", "FI", "Helsinki"));
        countries.add(new Country("Irlandia", "IE", "Dublin"));
        countries.add(new Country("Islandia", "IS", "Reykjavik"));
        countries.add(new Country("Litwa", "LT", "Wilno"));
        countries.add(new Country("Łotwa", "LV", "Ryga"));
        countries.add(new Country("Luksemburg", "LU", "Luksemburg"));
        countries.add(new Country("Macedonia Północna", "MK", "Skopje"));
        countries.add(new Country("Malta", "MT", "Valletta"));
        countries.add(new Country("Mołdawia", "MD", "Kiszyniów"));
        countries.add(new Country("Monako", "MC", "Monako"));
        countries.add(new Country("Rumunia", "RO", "Bukareszt"));
        countries.add(new Country("Serbia", "RS", "Belgrad"));
        countries.add(new Country("Słowacja", "SK", "Bratysława"));
        countries.add(new Country("Słowenia", "SI", "Lublana"));
        countries.add(new Country("Szwajcaria", "CH", "Berno"));
        countries.add(new Country("Turcja", "TR", "Ankara"));
        countries.add(new Country("Ukraina", "UA", "Kijów"));
        countries.add(new Country("Węgry", "HU", "Budapeszt"));
        Collections.shuffle(countries);

        return countries;
    }
}