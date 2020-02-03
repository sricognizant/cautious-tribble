package org.micronaut.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Test;
import org.micronaut.domain.Badge;
import org.micronaut.domain.GameStats;
import org.micronaut.service.GameService;
import org.micronaut.service.GameServiceImpl;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class ScoreCardControllerTest {

    @Inject
    GameService gameService;

    @Inject
    @Client("/")
    RxHttpClient client;

    @Test
    void gamestatUserTest() {
        GameStats gameStats = new GameStats(1l, 100, Badge.GOLD);
        when(gameService.computeBatch(1l)).thenReturn(gameStats);

        HttpResponse<GameStats> response = client.toBlocking().exchange(HttpRequest.GET("/scorecard/gamestats/1"),
                GameStats.class);

        assertEquals(gameStats.getScore(), response.body().getScore());
        assertEquals(HttpStatus.OK, response.status());
    }

    @MockBean(GameServiceImpl.class)
    GameService gameService() {
        return mock(GameService.class);
    }

}
