package org.micronaut;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import org.micronaut.domain.Trivia;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public interface TriviaApi {

    @Get("/")
    List<Trivia> listTrivia();

    @Get("/{id}")
    Trivia show(@NotNull Long id);

    @Post("/")
    Trivia save(@NotBlank String question, @NotBlank String choices, @NotBlank int answer);

}
