package org.micronaut.controller;


import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.micronaut.domain.Trivia;
import org.micronaut.service.TriviaService;
import org.micronaut.service.TriviaServiceImpl;

import javax.inject.Inject;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class TriviaControllerTest {

    @Inject
    @Client("/")
    RxHttpClient client;

    @Inject
    TriviaService triviaService;

    @Test
    void testGetTrivia() {
        when(triviaService.getTrivia()).thenReturn(new Trivia("Who is the president of the USA",
                "Obama|Trump|Lincon", 1));
        Trivia trivia = client.toBlocking().retrieve(HttpRequest.GET("/questions"), Trivia.class);
        Assertions.assertEquals("Who is the president of the USA", trivia.getQuestion());
    }

    @MockBean(TriviaServiceImpl.class)
    TriviaService triviaService() {
        return mock(TriviaService.class);
    }
}
