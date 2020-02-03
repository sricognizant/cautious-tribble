package org.micronaut.service;

import org.micronaut.domain.LeaderBoard;
import org.micronaut.domain.ScoreCard;
import org.micronaut.repository.ScoreCardRepository;

import javax.inject.Singleton;
import java.util.List;
import java.util.stream.Collectors;

@Singleton
public class LeaderBoardServiceImpl implements LeaderBoardService {

    private ScoreCardRepository scoreCardRepository;

    public LeaderBoardServiceImpl(ScoreCardRepository scoreCardRepository) {
        this.scoreCardRepository = scoreCardRepository;
    }

    private static LeaderBoard mapToLeaderBoard(Object[] obj) {
        String uId = String.valueOf(obj[0]);
        String ttlScore = String.valueOf(obj[1]);
        return new LeaderBoard(uId, ttlScore);
    }

    @Override
    public List<LeaderBoard> getAllLeaderBoardStats() {
        List<Object[]> leaderBoardResults = scoreCardRepository.findAllLeaders();
        return leaderBoardResults.stream().map(LeaderBoardServiceImpl::mapToLeaderBoard)
                .collect(Collectors.toList());
    }
}
