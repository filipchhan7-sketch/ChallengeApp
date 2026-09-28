package com.philip.ChallengeApp.Service;

import com.philip.ChallengeApp.Entity.Challenge;
import com.philip.ChallengeApp.Repository.ChallengeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {

    private final ChallengeRepository challengeRepository;
/*
    private List<Challenge> challenges =
            new ArrayList<>();
    private Long nextId = 1L;
*/

    public ChallengeService(ChallengeRepository challengeRepository){
            this.challengeRepository = challengeRepository;
    }

    // Get all challenges
    public List<Challenge> getAllChallenges(){
        return challengeRepository.findAll();
    }

/*    public boolean addChallenge(Challenge challenge){
        if (challenge != null){
            challenge.setId(nextId++);
            challenges.add(challenge);
            return true;
        }else {
            return false;
        }

 */
    // Get challenges by ID
    public Challenge getChallengeById(Long id){
        return challengeRepository.findById(id)
                .orElse(null);
    }

    // Create challenges
    public Challenge createChallenge(Challenge challenge){
        return challengeRepository.save(challenge);
    }

    // Update challenge
    public Challenge updateChallenge(Long id, Challenge challenge){

        Challenge existingChallenge = challengeRepository.findById(id)
                .orElse(null);
        if (existingChallenge == null){
            return null;
        }

        existingChallenge.setMonth(challenge.getMonth());
        existingChallenge.setDescription(challenge.getDescription());

        return challengeRepository.save(existingChallenge);
    }

    // Delete challenge
    public void deleteChallenge(Long id){
        challengeRepository.deleteById(id);
    }



}

/*
    public Challenge getChallenges(String month) {
        for (Challenge challenge: challenges){
            if (challenge.getMonth().equalsIgnoreCase(month)){
                return challenge;
            }
        }
        return null;
    }

   public boolean updateChallenge(Long id, Challenge updateChallenge) {
        for (Challenge challenge: challenges){
            if (challenge.getId().equals(id)){
                challenge.setMonth(updateChallenge.getMonth());
                challenge.setDescription(updateChallenge.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        return challenges.removeIf(challenge -> challenge.getId().equals(id));
    }
}

 */
