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
import org.micronaut.domain.Trivia;
import org.micronaut.domain.User;
import org.micronaut.service.TriviaResultService;
import org.micronaut.service.TriviaResultServiceImpl;

import javax.inject.Inject;

import java.util.Arrays;
import java.util.List;

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


    //@Test
    void testPostResultAttempt() {

        ResultAttempt resultAttempt = new ResultAttempt(new User("Obama"),
                1L,"Donald Trump", true );

        //when(triviaResultService.postTriviaResults("Obama", "Donald Trump", 1L, true))
          //      .thenReturn(resultAttempt);

         HttpResponse response = client.toBlocking().exchange(HttpRequest.POST("results", resultAttempt));

        assertEquals(HttpStatus.CREATED, response.getStatus());
    }

   /* @Test
    void testGetResultAttempt() {
        ResultAttempt resultAttempt1 = new ResultAttempt(new User("Obama"),
                1L,"Donald Trump", true );

        ResultAttempt resultAttempt2 = new ResultAttempt(new User("Jordan"),
                2L,"NBA", true );

        when(triviaResultService.getResults(1L)).
                thenReturn(Arrays.asList(resultAttempt1, resultAttempt2));

        ResultAttempt[] response = client.toBlocking().retrieve(HttpRequest.GET("/results/users/Obama"),
                ResultAttempt[].class);

        assertEquals(HttpStatus.CREATED, null);

    }*/



    @MockBean(TriviaResultServiceImpl.class)
    TriviaResultService triviaResultService() {
        return mock(TriviaResultService.class);
    }

}
