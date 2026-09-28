package com.philip.ChallengeApp.Repository;

import com.philip.ChallengeApp.Entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
}
