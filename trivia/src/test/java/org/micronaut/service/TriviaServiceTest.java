package org.micronaut.service;


import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.micronaut.domain.Trivia;
import org.micronaut.repository.TriviaRepository;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@MicronautTest
public class TriviaServiceTest {

    @Inject
    TriviaService triviaService;

    @Inject
    TriviaRepository triviaRepository;

    @Test
    void getTrivia(){
        List<Trivia> list = Arrays.asList(new Trivia("Who is the president of the USA",
                "Obama|Trump|Lincon", 1),
                new Trivia("What's the real name of Spiderman", "" +
                        "Peter Parker|Peter Pan|John Stark", 2));

        when(triviaRepository.findAll()).thenReturn(list);

         final String question = triviaService.getTrivia(0).getQuestion();

        Assertions.assertTrue(question.equalsIgnoreCase("Who is the president of the USA")
                || question.equalsIgnoreCase("What's the real name of Spiderman"));
    }


    @MockBean(TriviaRepository.class)
    TriviaRepository triviaRepository() {
        return mock(TriviaRepository.class);
    }
}
