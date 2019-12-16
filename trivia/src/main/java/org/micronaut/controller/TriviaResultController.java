package org.micronaut.controller;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.validation.Validated;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.service.TriviaResultService;

import java.util.List;

@Controller("/results")
@Validated
public class TriviaResultController {

    private TriviaResultService triviaResultService;

    public TriviaResultController(TriviaResultService triviaResultService) {
        this.triviaResultService = triviaResultService;
    }

    @Post
    public HttpStatus save(@Body ResultAttempt resultAttempt) {
        triviaResultService.postTriviaResults(resultAttempt);
        return HttpStatus.CREATED;
    }


    @Get(value = "/users/{name}", produces = MediaType.APPLICATION_JSON)
    public List<ResultAttempt> getTrivia(@PathVariable String name) {
        return triviaResultService.getResults(name);
    }
}
