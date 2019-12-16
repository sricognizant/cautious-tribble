package org.micronaut.repository;


import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.User;

import javax.inject.Inject;
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
        resultAttempt1.setAnswer("Donald Trump");
        resultAttempt1.setQuestion("Who is the president of the USA");
        resultAttempt1.setResult(true);
        resultAttempt1.setUser(new User("Joe"));

        ResultAttempt resultAttempt2 = new ResultAttempt();
        resultAttempt2.setAnswer("Peter Parker");
        resultAttempt2.setQuestion("What's the real name of Spiderman");
        resultAttempt2.setResult(true);
        resultAttempt2.setUser(new User("John"));

        repository.save(resultAttempt1);
        repository.save(resultAttempt2);
        assertEquals(2, repository.count());

        List<ResultAttempt> attempt = repository.findByUserName("Joe");
        assertSame("Donald Trump", attempt.get(0).getAnswer());
    }

}
