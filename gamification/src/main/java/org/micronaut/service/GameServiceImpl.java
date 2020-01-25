package org.micronaut.service;

import org.micronaut.domain.Badge;
import org.micronaut.domain.GameStats;
import org.micronaut.domain.Result;
import org.micronaut.domain.ScoreCard;
import org.micronaut.repository.ScoreCardRepository;

import javax.inject.Singleton;

@Singleton
public class GameServiceImpl implements GameService {


    private ScoreCardRepository scoreCardRepository;

    public GameServiceImpl(ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }

    @Override
    public GameStats computeBatch(long userId) {
        int totalScoreUser = scoreCardRepository.findSumScoreByUserId(userId);
        int totalAttemptUser = scoreCardRepository.countByUserId(userId);
        double scorePercentage = calculateScorePercentage(totalScoreUser, totalAttemptUser);
        Badge badge = BadgeType(scorePercentage);
        GameStats gameStats = new GameStats(userId, totalScoreUser, badge);
        return gameStats;
    }

    @Override
    public void newAttemptForUser(Result result) {
        int score = calculateScore(result.isCorrect());
        ScoreCard scoreCard = new ScoreCard(result.getUserId(), result.getAttemptId(), score);
        scoreCardRepository.save(scoreCard);
    }

    private Badge BadgeType(double scorePercentage) {
        if (scorePercentage > 80) {
            return Badge.GOLD;
        } else if (scorePercentage <= 80 && scorePercentage >= 40) {
            return Badge.SILVER;
        } else {
            return Badge.BRONZE;
        }
    }

    private int calculateScore(boolean correct) {
        return correct == true ? 10 : 0;
    }

    private double calculateScorePercentage(int totalScoreUser, int totalAttemptUser) {
        return (totalScoreUser * 100) / (totalAttemptUser * 10);
    }
}
