package com.mapgame.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Arrays;

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
                new Country("Albania", "AL", "Tirana", "Europa Południowa", "2.8 mln", "28 748 km²", List.of("Albański"), "W Albanii kręcenie głową oznacza 'tak', a kiwanie oznacza 'nie'!"),
                new Country("Białoruś", "BY", "Mińsk", "Europa Wschodnia", "9.3 mln", "207 600 km²", List.of("Białoruski", "Rosyjski"), "Około 40% powierzchni Białorusi stanowią lasy, stąd nazywa się ją 'płucami Europy'!"),
                new Country("Bośnia i Hercegowina", "BA", "Sarajewo", "Europa Południowa", "3.2 mln", "51 129 km²", List.of("Bośniacki", "Chorwacki", "Serbski"), "Sarajewo było gospodarzem Zimowych Igrzysk Olimpijskich w 1984 roku!"),
                new Country("Bułgaria", "BG", "Sofia", "Europa Południowa", "6.9 mln", "110 994 km²", List.of("Bułgarski"), "Bułgaria jest jednym z najstarszych producentów oleju różanego na świecie!"),
                new Country("Chorwacja", "HR", "Zagrzeb", "Europa Południowa", "4 mln", "56 594 km²", List.of("Chorwacki"), "Krawat wywodzi się z Chorwacji, gdzie nosili go XVII-wieczni chorwaccy żołnierze!"),
                new Country("Cypr", "CY", "Nikozja", "Europa Południowa", "1.2 mln", "9 251 km²", List.of("Grecki", "Turecki"), "Cypr jest znany jako wyspa Afrodyty – greckiej bogini miłości, która miała się tam wyłonić z piany morskiej!"),
                new Country("Estonia", "EE", "Tallinn", "Europa Północna", "1.3 mln", "45 227 km²", List.of("Estoński"), "Estonia ma jeden z najbardziej zaawansowanych systemów cyfrowych na świecie i jest pionierem e-głosowania!"),
                new Country("Finlandia", "FI", "Helsinki", "Europa Północna", "5.5 mln", "338 424 km²", List.of("Fiński", "Szwedzki"), "W Finlandii znajduje się ponad 188 000 jezior oraz więcej saun niż samochodów!"),
                new Country("Irlandia", "IE", "Dublin", "Europa Zachodnia", "5 mln", "70 273 km²", List.of("Irlandzki", "Angielski"), "W Irlandii nie ma węży na wolności, co według legendy zawdzięcza się św. Patrykowi!"),
                new Country("Islandia", "IS", "Reykjavik", "Europa Północna", "370 tys.", "103 000 km²", List.of("Islandzki"), "Islandia nie posiada żadnych komarów, a większość energii pochodzi ze źródeł geotermalnych!"),
                new Country("Litwa", "LT", "Wilno", "Europa Wschodnia", "2.8 mln", "65 300 km²", List.of("Litewski"), "Język litewski jest jednym z najstarszych wciąż używanych języków indoeuropejskich na świecie!"),
                new Country("Łotwa", "LV", "Ryga", "Europa Wschodnia", "1.9 mln", "64 589 km²", List.of("Łotewski"), "Łotwa ma jedną z najstarszych zachowanych tradycji śpiewaczych na świecie – festiwal pieśni odbywa się co 5 lat!"),
                new Country("Luksemburg", "LU", "Luksemburg", "Europa Zachodnia", "640 tys.", "2 586 km²", List.of("Luksemburski", "Francuski", "Niemiecki"), "Luksemburg jest jedynym wielkim księstwem na świecie, a transport publiczny jest tam w pełni bezpłatny!"),
                new Country("Macedonia Północna", "MK", "Skopje", "Europa Południowa", "2 mln", "25 713 km²", List.of("Macedoński"), "W Skopje urodziła się słynna misjonarka i laureatka Pokojowej Nagrody Nobla – Matka Teresa!"),
                new Country("Malta", "MT", "Valletta", "Europa Południowa", "520 tys.", "316 km²", List.of("Maltański", "Angielski"), "Malta jest jednym z najmniejszych i najbardziej zaludnionych krajów świata, a jej historia sięga ponad 7000 lat!"),
                new Country("Mołdawia", "MD", "Kiszyniów", "Europa Wschodnia", "2.6 mln", "33 846 km²", List.of("Rumuński"), "W Mołdawii znajdują się Mileștii Mici – największa piwnica winna świata, licząca ponad 200 km korytarzy!"),
                new Country("Monako", "MC", "Monako", "Europa Zachodnia", "39 tys.", "2.02 km²", List.of("Francuski"), "Monako jest drugim najmniejszym państwem świata, ale ma największą gęstość zaludnienia!"),
                new Country("Rumunia", "RO", "Bukareszt", "Europa Wschodnia", "19 mln", "238 397 km²", List.of("Rumuński"), "W Rumunii leży malowniczy region Transylwanii, znany z legend o hrabim Drakuli i zamku Bran!"),
                new Country("Serbia", "RS", "Belgrad", "Europa Południowa", "6.8 mln", "88 361 km²", List.of("Serbski"), "W Serbii urodził się Nikola Tesla, jeden z najważniejszych wynalazców w historii ludzkości!"),
                new Country("Słowacja", "SK", "Bratysława", "Europa Środkowa", "5.4 mln", "49 035 km²", List.of("Słowacki"), "Słowacja ma najwięcej zamków i pałaców na mieszkańca w całej Europie!"),
                new Country("Słowenia", "SI", "Lublana", "Europa Środkowa", "2.1 mln", "20 273 km²", List.of("Słoweński"), "Słowenia jest jedynym krajem, który ma słowo 'love' (miłość) ukryte w swojej angielskiej nazwie (sLOVEnia)!"),
                new Country("Szwajcaria", "CH", "Berno", "Europa Zachodnia", "8.7 mln", "41 285 km²", List.of("Niemiecki", "Francuski", "Włoski", "Romansz"), "Szwajcarska czekolada jest znana na całym świecie – przeciętny Szwajcar zjada jej ponad 10 kg rocznie!"),
                new Country("Turcja", "TR", "Ankara", "Europa Południowa", "85 mln", "783 562 km²", List.of("Turecki"), "Stambuł jest jedynym miastem na świecie, które leży na dwóch kontynentach: w Europie i w Azji!"),
                new Country("Ukraina", "UA", "Kijów", "Europa Wschodnia", "41 mln", "603 548 km²", List.of("Ukraiński"), "Ukraina jest największym państwem leżącym w całości na terytorium Europy!"),
                new Country("Węgry", "HU", "Budapeszt", "Europa Środkowa", "9.7 mln", "93 028 km²", List.of("Węgierski"), "Kostka Rubika została wynaleziona przez węgierskiego rzeźbiarza i profesora architektury Erno Rubika!")
            );

            repository.saveAll(countries);
            System.out.println("--- BAZA ZAŁADOWANA POMYŚLNIE (" + countries.size() + " krajów) ---");
        } else {
            System.out.println("--- BAZA JUŻ ZAWIERA DANE, POMIJAM ŁADOWANIE ---");
        }
    }
}