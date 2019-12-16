package org.micronaut.service;


import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.Trivia;
import org.micronaut.domain.User;
import org.micronaut.repository.TriviaResultRepository;

import javax.inject.Inject;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class TriviaResultServiceTest {

    @Inject
    TriviaResultRepository repository;

    @Inject
    TriviaResultService triviaResultService;


    @Test
    void getTriviaResults(){

        ResultAttempt resultAttempt1 = new ResultAttempt();
        resultAttempt1.setAnswered("Donald Trump");
        resultAttempt1.setQuizId(1L);
        resultAttempt1.setResult(true);
        resultAttempt1.setUser(new User("Joe"));

        ResultAttempt resultAttempt2 = new ResultAttempt();
        resultAttempt2.setAnswered("Peter Parker");
        resultAttempt2.setQuizId(2L);
        resultAttempt2.setResult(true);
        resultAttempt2.setUser(new User("Joe"));

        List<ResultAttempt> list = Arrays.asList(resultAttempt1, resultAttempt2);
        when(repository.findByUserName("Joe")).thenReturn(list);

        final List<ResultAttempt> resultAttempts = triviaResultService.getResults("Joe");

        assertEquals(resultAttempts.get(0).getAnswered(), resultAttempt1.getAnswered());
        assertEquals(resultAttempts.get(1).getAnswered(), resultAttempt2.getAnswered());

    }

    @MockBean(TriviaResultRepository.class)
    TriviaResultRepository triviaResultRepository() {
        return mock(TriviaResultRepository.class);
    }
}
