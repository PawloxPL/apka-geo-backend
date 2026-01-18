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
            System.out.println("--- ROZPOCZYNAM ŁADOWANIE DANYCH DO BAZY POSTGRESQL ---");
            
            List<Country> countries = Arrays.asList(
                new Country("Polska", "PL", "Warszawa", "Europa Środkowa", "38 mln", "312 696 km²", List.of("Polski"), "Polska ma najdłuższą linię brzegową Morza Bałtyckiego!"),
                new Country("Niemcy", "DE", "Berlin", "Europa Środkowa", "83 mln", "357 022 km²", List.of("Niemiecki"), "Niemcy mają ponad 1500 różnych rodzajów piwa!"),
                new Country("Francja", "FR", "Paryż", "Europa Zachodnia", "67 mln", "643 801 km²", List.of("Francuski"), "Wieża Eiffla może się wydłużyć o 15 cm w upalne dni!"),
                new Country("Hiszpania", "ES", "Madryt", "Europa Południowa", "47 mln", "505 990 km²", List.of("Hiszpański"), "Hiszpania ma ponad 8000 km wybrzeża!"),
                new Country("Włochy", "IT", "Rzym", "Europa Południowa", "60 mln", "301 340 km²", List.of("Włoski"), "We Włoszech znajduje się najwięcej wulkanów w Europie!"),
                new Country("Wielka Brytania", "GB", "Londyn", "Europa Zachodnia", "67 mln", "242 495 km²", List.of("Angielski"), "W Londynie jest więcej Indian niż w jakimkolwiek innym mieście poza Indiami!"),
                new Country("Szwecja", "SE", "Sztokholm", "Europa Północna", "10 mln", "450 295 km²", List.of("Szwedzki"), "Szwecja ma ponad 100 000 jezior!"),
                new Country("Norwegia", "NO", "Oslo", "Europa Północna", "5 mln", "385 207 km²", List.of("Norweski"), "Norwegia ma najdłuższą linię brzegową na świecie!"),
                new Country("Grecja", "GR", "Ateny", "Europa Południowa", "11 mln", "131 957 km²", List.of("Grecki"), "Grecja ma ponad 6000 wysp!"),
                new Country("Portugalia", "PT", "Lizbona", "Europa Zachodnia", "10 mln", "92 090 km²", List.of("Portugalski"), "Portugalia jest najstarszym krajem w Europie z niezmienionymi granicami!"),
                new Country("Holandia", "NL", "Amsterdam", "Europa Zachodnia", "17 mln", "41 543 km²", List.of("Holenderski"), "W Holandii jest więcej rowerów niż ludzi!"),
                new Country("Belgia", "BE", "Bruksela", "Europa Zachodnia", "11 mln", "30 528 km²", List.of("Holenderski", "Francuski", "Niemiecki"), "Belgia produkuje 220 000 ton czekolady rocznie!"),
                new Country("Austria", "AT", "Wiedeń", "Europa Środkowa", "9 mln", "83 871 km²", List.of("Niemiecki"), "Austria jest jednym z najbardziej zalesionych krajów w Europie!"),
                new Country("Czechy", "CZ", "Praga", "Europa Środkowa", "11 mln", "78 867 km²", List.of("Czeski"), "Czesi piją więcej piwa na osobę niż jakikolwiek inny naród!"),
                new Country("Dania", "DK", "Kopenhaga", "Europa Północna", "6 mln", "42 933 km²", List.of("Duński"), "Dania składa się z jednego półwyspu i 443 wysp!"),
                new Country("Albania", "AL", "Tirana"),
                new Country("Białoruś", "BY", "Mińsk"),
                new Country("Bośnia i Hercegowina", "BA", "Sarajewo"),
                new Country("Bułgaria", "BG", "Sofia"),
                new Country("Chorwacja", "HR", "Zagrzeb"),
                new Country("Cypr", "CY", "Nikozja"),
                new Country("Estonia", "EE", "Tallinn"),
                new Country("Finlandia", "FI", "Helsinki"),
                new Country("Irlandia", "IE", "Dublin"),
                new Country("Islandia", "IS", "Reykjavik"),
                new Country("Litwa", "LT", "Wilno"),
                new Country("Łotwa", "LV", "Ryga"),
                new Country("Luksemburg", "LU", "Luksemburg"),
                new Country("Macedonia Północna", "MK", "Skopje"),
                new Country("Malta", "MT", "Valletta"),
                new Country("Mołdawia", "MD", "Kiszyniów"),
                new Country("Monako", "MC", "Monako"),
                new Country("Rumunia", "RO", "Bukareszt"),
                new Country("Serbia", "RS", "Belgrad"),
                new Country("Słowacja", "SK", "Bratysława"),
                new Country("Słowenia", "SI", "Lublana"),
                new Country("Szwajcaria", "CH", "Berno"),
                new Country("Turcja", "TR", "Ankara"),
                new Country("Ukraina", "UA", "Kijów"),
                new Country("Węgry", "HU", "Budapeszt")
            );

            repository.saveAll(countries);
            System.out.println("--- BAZA ZAŁADOWANA POMYŚLNIE (" + countries.size() + " krajów) ---");
        } else {
            System.out.println("--- BAZA JUŻ ZAWIERA DANE, POMIJAM ŁADOWANIE ---");
        }
    }
}