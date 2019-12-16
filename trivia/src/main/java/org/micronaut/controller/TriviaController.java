package org.micronaut.controller;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import org.micronaut.domain.Trivia;
import org.micronaut.service.TriviaService;

@Controller("/questions")
@Validated
public class TriviaController  {

    private TriviaService triviaService;

    public TriviaController(TriviaService triviaService) {
        this.triviaService = triviaService;
    }

    @Get(produces = MediaType.APPLICATION_JSON)
    public Trivia getTrivia(){
        return triviaService.getTrivia();
    }

}
