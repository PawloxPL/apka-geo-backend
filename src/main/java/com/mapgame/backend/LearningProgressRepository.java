package com.mapgame.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface LearningProgressRepository extends JpaRepository<LearningProgress, Long> {
    List<LearningProgress> findByUsernameAndGameMode(String username, String gameMode);
    boolean existsByUsernameAndGameModeAndCountryCode(String username, String gameMode, String countryCode);
    
    @Transactional
    void deleteByUsernameAndGameMode(String username, String gameMode);
}
