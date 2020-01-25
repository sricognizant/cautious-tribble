package org.micronaut.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.validation.Validated;
import org.micronaut.domain.LeaderBoard;
import org.micronaut.domain.Result;
import org.micronaut.domain.ResultTrivia;
import org.micronaut.service.GameService;
import org.micronaut.service.LeaderBoardService;

import java.util.List;


@Controller
@Validated
public class LeaderBoardController {

    private LeaderBoardService leaderBoardService;

    private GameService gameService;

    public LeaderBoardController(LeaderBoardService leaderBoardService, GameService gameService) {
        this.leaderBoardService = leaderBoardService;
        this.gameService = gameService;
    }

    // getting the results from Trivia app
    @Post(value = "/results", consumes = MediaType.APPLICATION_JSON)
    public HttpResponse<Result> save(@Body ResultTrivia resultTrivia) {
        try {
            Result result = new Result(resultTrivia.getUserId(), resultTrivia.getAttemptId(),
                    resultTrivia.getIsCorrect() == 1 ? true: false);
            gameService.newAttemptForUser(result);
            return HttpResponse.ok(result);
        } catch (Exception e) {
            return HttpResponse.badRequest();
        }
    }

    // getting all the leaderboard
    @Get(value = "/scorecard/leaderboard", produces = MediaType.APPLICATION_JSON)
    public List<LeaderBoard> leaderBoardScores() {
        return leaderBoardService.getAllLeaderBoardStats();
    }
}
