package org.micronaut.service;

import org.micronaut.domain.LeaderBoard;
import org.micronaut.domain.ScoreCard;

import javax.transaction.Transactional;
import java.util.List;

public interface LeaderBoardService {
    List<ScoreCard> getAllScoreCards();

    /*
    * Mapping the Object [], returned from database with userid and score to leaderboard obj
    **/
    @Transactional
    List<LeaderBoard> getAllLeaderBoardStats();
}
