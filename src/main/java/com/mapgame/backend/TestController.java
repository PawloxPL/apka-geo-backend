package com.mapgame.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/test")
    public Map<String, String> testConnection() {
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "sukces");
        map.put("message", "Backend w Spring Boot działa i widzi Frontend!");
        return map;
    }
}