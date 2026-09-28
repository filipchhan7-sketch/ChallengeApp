package com.philip.ChallengeApp.Controller;

import com.philip.ChallengeApp.Entity.Challenge;
import com.philip.ChallengeApp.Service.ChallengeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/challenges")
public class ChallengeController {

    private final ChallengeService challengeService;

    public ChallengeController(ChallengeService challengeService) {
        this.challengeService = challengeService;
    }

    // GET all challenges
    @GetMapping
    public List<Challenge> getAllChallenges() {
        return challengeService.getAllChallenges();
    }

    // GET challenge by ID
    @GetMapping("/{id}")
    public Challenge getChallengeById(@PathVariable Long id) {
        return challengeService.getChallengeById(id);
    }

    // POST create challenge
    @PostMapping
    public Challenge createChallenge(@RequestBody Challenge challenge) {
        return challengeService.createChallenge(challenge);
    }

    // PUT update challenge
    @PutMapping("/{id}")
    public Challenge updateChallenge(
            @PathVariable Long id,
            @RequestBody Challenge challenge) {

        return challengeService.updateChallenge(id, challenge);
    }

    // DELETE challenge
    @DeleteMapping("/{id}")
    public void deleteChallenge(@PathVariable Long id) {
        challengeService.deleteChallenge(id);
    }
}