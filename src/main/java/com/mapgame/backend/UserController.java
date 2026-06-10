package com.mapgame.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/profile")
    public ResponseEntity<?> getUserProfile(@RequestParam String username) {
        Optional<User> userOpt = userRepository.findByUsername(username.trim());
        if (userOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        User user = userOpt.get();
        return ResponseEntity.ok(Map.of(
            "username", user.getUsername(),
            "xp", user.getXp()
        ));
    }

    @PostMapping("/add-xp")
    public ResponseEntity<?> addXp(@RequestBody Map<String, Object> request) {
        String username = (String) request.get("username");
        Integer amount = (Integer) request.get("amount");

        if (username == null || amount == null) {
            return ResponseEntity.badRequest().body(Map.of("success", false, "message", "Niekompletne dane!"));
        }

        Optional<User> userOpt = userRepository.findByUsername(username.trim());
        if (userOpt.isEmpty()) {
            return ResponseEntity.status(404).body(Map.of("success", false, "message", "Użytkownik nie istnieje!"));
        }

        User user = userOpt.get();
        user.setXp(user.getXp() + amount);
        userRepository.save(user);

        return ResponseEntity.ok(Map.of(
            "success", true,
            "message", "XP zaktualizowane!",
            "xp", user.getXp()
        ));
    }

    @GetMapping("/leaderboard")
    public ResponseEntity<?> getXpLeaderboard() {
        List<User> users = userRepository.findAllByOrderByXpDesc();
        List<Map<String, Object>> mappedUsers = users.stream().map(u -> Map.<String, Object>of(
            "username", u.getUsername(),
            "xp", u.getXp()
        )).toList();
        return ResponseEntity.ok(mappedUsers);
    }
}
