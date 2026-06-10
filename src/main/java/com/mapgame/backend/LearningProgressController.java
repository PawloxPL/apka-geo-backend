package com.mapgame.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/learning")
public class LearningProgressController {

    private final LearningProgressRepository repository;

    public LearningProgressController(LearningProgressRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/progress")
    public ResponseEntity<List<String>> getProgress(
            @RequestParam String username,
            @RequestParam String gameMode) {
        List<LearningProgress> list = repository.findByUsernameAndGameMode(username, gameMode);
        List<String> learnedCodes = list.stream()
                .map(LearningProgress::getCountryCode)
                .toList();
        return ResponseEntity.ok(learnedCodes);
    }

    @PostMapping("/progress")
    public ResponseEntity<?> saveProgress(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String gameMode = request.get("gameMode");
        String countryCode = request.get("countryCode");

        if (username == null || gameMode == null || countryCode == null) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Brakujące dane postępu!"));
        }

        if (!repository.existsByUsernameAndGameModeAndCountryCode(username, gameMode, countryCode)) {
            LearningProgress lp = new LearningProgress(username, gameMode, countryCode);
            repository.save(lp);
        }

        return ResponseEntity.ok(Map.of("success", true, "message", "Zapisano postęp nauki!"));
    }

    @PostMapping("/reset")
    public ResponseEntity<?> resetProgress(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String gameMode = request.get("gameMode");

        if (username == null || gameMode == null) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Brakujące dane resetu!"));
        }

        repository.deleteByUsernameAndGameMode(username, gameMode);
        return ResponseEntity.ok(Map.of("success", true, "message", "Postęp nauki został zresetowany!"));
    }
}
