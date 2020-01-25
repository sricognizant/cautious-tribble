package org.micronaut.service;

import org.micronaut.domain.GameStats;
import org.micronaut.domain.Result;

public interface GameService {
    GameStats computeBatch(long userId);

    void newAttemptForUser(Result result);
}
