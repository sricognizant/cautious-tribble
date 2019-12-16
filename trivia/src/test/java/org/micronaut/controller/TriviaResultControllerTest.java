package org.micronaut.controller;


import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Test;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.User;
import org.micronaut.service.TriviaResultService;
import org.micronaut.service.TriviaResultServiceImpl;

import javax.inject.Inject;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class TriviaResultControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Inject
    TriviaResultService triviaResultService;

    @Test
    void testPostResultAttempt() {

        ResultAttempt resultAttempt = new ResultAttempt();
        resultAttempt.setAnswer("Donald Trump");
        resultAttempt.setQuestion("Who is the president of the USA");
        resultAttempt.setResult(true);
        resultAttempt.setUser(new User("Joe"));

        when(triviaResultService.postTriviaResults(resultAttempt))
                .thenReturn(resultAttempt);

         HttpResponse response = client.toBlocking().exchange(HttpRequest.POST("results", resultAttempt));

        assertEquals(HttpStatus.CREATED, response.getStatus());
    }

    @Test
    void testGetResultAttempt() {
        ResultAttempt resultAttempt1 = new ResultAttempt();
        resultAttempt1.setAnswer("Donald Trump");
        resultAttempt1.setQuestion("Who is the president of the USA");
        resultAttempt1.setResult(true);
        resultAttempt1.setUser(new User("Joe"));

        ResultAttempt resultAttempt2 = new ResultAttempt();
        resultAttempt2.setAnswer("Peter Parker");
        resultAttempt2.setQuestion("What's the real name of Spiderman");
        resultAttempt2.setResult(true);
        resultAttempt2.setUser(new User("Joe"));

        when(triviaResultService.getResults("Joe")).
                thenReturn(Arrays.asList(resultAttempt1, resultAttempt2));

        ResultAttempt[] response = client.toBlocking().retrieve(HttpRequest.GET("/results/users/Joe"),
                ResultAttempt[].class);

        assertEquals(2, response.length);

    }



    @MockBean(TriviaResultServiceImpl.class)
    TriviaResultService triviaResultService() {
        return mock(TriviaResultService.class);
    }

}
