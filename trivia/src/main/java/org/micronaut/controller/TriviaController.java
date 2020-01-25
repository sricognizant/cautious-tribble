package org.micronaut.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.validation.Validated;
import org.micronaut.domain.Trivia;
import org.micronaut.service.TriviaService;

@Controller("/questions")
@Validated
public class TriviaController {

    private TriviaService triviaService;

    public TriviaController(TriviaService triviaService) {
        this.triviaService = triviaService;
    }

    @Get(value = "/{count}", produces = MediaType.APPLICATION_JSON)
    public Trivia getTrivia(@PathVariable int count) {
        return triviaService.getTrivia(count);
    }

}
