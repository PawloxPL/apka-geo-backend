package com.mapgame.backend;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {

    @Id // To jest klucz główny
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String name;
    public String code;
    public String capital;
    
    public String region;
    public String population;
    public String area;

    @ElementCollection
    public List<String> languages;
    
    @Column(length = 1000)
    public String funFact;

    public Country() {}

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