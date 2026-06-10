package com.mapgame.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long> {
    List<Score> findByGameModeOrderByScoreDescCreatedAtDesc(String gameMode);
    List<Score> findByGameModeAndUsernameOrderByScoreDescCreatedAtDesc(String gameMode, String username);
}
