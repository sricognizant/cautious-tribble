package org.micronaut;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import org.micronaut.domain.ResultAttempt;
import javax.validation.constraints.NotNull;

public interface TriviaResultApi {

    @Post
    ResultAttempt save(@NotNull String userName, @NotNull String answer, @NotNull Long quizId, @NotNull boolean result);

    @Get("/{id}")
    ResultAttempt show(@NotNull Long id);


}
