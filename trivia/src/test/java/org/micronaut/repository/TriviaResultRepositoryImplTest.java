package org.micronaut.repository;


import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.User;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@MicronautTest
public class TriviaResultRepositoryImplTest {

    @Inject
    TriviaResultRepository repository;

    @Test
    void getResultAttempts() {

        ResultAttempt resultAttempt1 = new ResultAttempt();
        resultAttempt1.setAnswer("Trump");
        resultAttempt1.setQuestion("Who is the president of the USA");
        resultAttempt1.setCorrect(true);
        resultAttempt1.setUserId(1l);
        resultAttempt1.setAttemptId(1);
        resultAttempt1.setLocalDateTime(LocalDateTime.now());

        ResultAttempt resultAttempt2 = new ResultAttempt();
        resultAttempt2.setAnswer("Peter Parker");
        resultAttempt2.setQuestion("What's the real name of Spiderman");
        resultAttempt2.setCorrect(true);
        resultAttempt2.setUserId(1l);
        resultAttempt2.setAttemptId(1);
        resultAttempt2.setLocalDateTime(LocalDateTime.now());

        repository.save(resultAttempt1);
        repository.save(resultAttempt2);
        assertEquals(2, repository.count());

        List<ResultAttempt> attempt = repository.findByUserId(1l);
        assertSame("Trump", attempt.get(0).getAnswer());
    }

}
