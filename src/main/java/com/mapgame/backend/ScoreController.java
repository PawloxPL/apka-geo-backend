package com.mapgame.backend;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/scores")
public class ScoreController {

    private final ScoreRepository scoreRepository;

    public ScoreController(ScoreRepository scoreRepository) {
        this.scoreRepository = scoreRepository;
    }

    @PostMapping
    public ResponseEntity<?> saveScore(@RequestBody Map<String, Object> request) {
        String username = (String) request.get("username");
        String gameMode = (String) request.get("gameMode");
        Integer scoreVal = (Integer) request.get("score");
        Integer maxScoreVal = (Integer) request.get("maxScore");

        if (username == null || gameMode == null || scoreVal == null || maxScoreVal == null) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Niekompletne dane wyniku!"));
        }

        Score score = new Score(username, gameMode, scoreVal, maxScoreVal, LocalDateTime.now());
        scoreRepository.save(score);

        return ResponseEntity.ok(Map.of("success", true, "message", "Wynik został zapisany!"));
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<List<Score>> getLeaderboard(
            @RequestParam String mode,
            @RequestParam(required = false) String username) {
        
        List<Score> scores;
        if (username != null && !username.trim().isEmpty()) {
            scores = scoreRepository.findByGameModeAndUsernameOrderByScoreDescCreatedAtDesc(mode, username.trim());
        } else {
            scores = scoreRepository.findByGameModeOrderByScoreDescCreatedAtDesc(mode);
        }
        return ResponseEntity.ok(scores);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteScore(@PathVariable Long id, @RequestParam String username) {
        Optional<Score> scoreOpt = scoreRepository.findById(id);
        if (scoreOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Score score = scoreOpt.get();
        if (!score.getUsername().equalsIgnoreCase(username)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of("success", false, "message", "Nie masz uprawnień do usunięcia tego wyniku!"));
        }
        scoreRepository.delete(score);
        return ResponseEntity.ok(Map.of("success", true, "message", "Wynik został usunięty!"));
    }
}
