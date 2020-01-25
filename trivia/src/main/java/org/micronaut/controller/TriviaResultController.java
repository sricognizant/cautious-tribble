package org.micronaut.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import org.micronaut.Utils;
import org.micronaut.domain.Response;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.ResultAttemptDTO;
import org.micronaut.domain.User;
import org.micronaut.service.TriviaResultService;
import org.micronaut.service.TriviaService;

import java.time.LocalDateTime;
import java.util.List;

@Controller("/results")
@Validated
public class TriviaResultController {

    private TriviaResultService triviaResultService;

    private GamificationClient gamificationClient;

    private TriviaService triviaService;

    public TriviaResultController(TriviaResultService triviaResultService, GamificationClient gamificationClient, TriviaService triviaService) {
        this.triviaResultService = triviaResultService;
        this.gamificationClient = gamificationClient;
        this.triviaService = triviaService;
    }

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public HttpResponse<ResultAttemptDTO> save(@Body Response response) {

        User user = triviaService.checkUser(response.getUser());

        int isCorrect = triviaResultService.checkResponse(response);

        /*Creates a new resultAttempt */
        ResultAttempt resultAttempt = new ResultAttempt(
                user.getId(),
                LocalDateTime.now(),
                response.getQuestion(),
                response.getAnswer(),
                Utils.generateAttemptId(),
                isCorrect == 1 ? true: false);

        ResultAttempt result = triviaResultService.postTriviaResults(resultAttempt);

        gamificationClient.save(result.getUserId(), Utils.generateAttemptId(), isCorrect);

        ResultAttemptDTO resultAttemptDTO = triviaResultService.resultAttemptDTO(resultAttempt);
        return HttpResponse.ok(resultAttemptDTO);
    }


    @Get(value = "/users/{userId}", produces = MediaType.APPLICATION_JSON)
    public List<ResultAttemptDTO> getTrivia(@PathVariable long userId) {
        return triviaResultService.getResults(userId);
    }
}
