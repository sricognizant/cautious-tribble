package org.micronaut.service;

import org.micronaut.domain.GameStats;
import org.micronaut.domain.Result;
import org.micronaut.domain.ResultTrivia;
import org.micronaut.domain.ScoreCard;

public interface GameService {
    GameStats computeBatch(long userId);

    ScoreCard newAttemptForUser(Result result);

    Result createNewResult(ResultTrivia resultTrivia);
}
