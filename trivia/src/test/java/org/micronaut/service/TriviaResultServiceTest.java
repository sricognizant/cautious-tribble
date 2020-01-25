package org.micronaut.service;


import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;
import org.junit.jupiter.api.Test;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.ResultAttemptDTO;
import org.micronaut.repository.TriviaResultRepository;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MicronautTest
public class TriviaResultServiceTest {

    @Inject
    TriviaResultRepository triviaResultRepository;

    @Inject
    TriviaResultService triviaResultService;


    @Test
    void getTriviaResults() {

        ResultAttemptDTO resultAttemptDTO1 = new ResultAttemptDTO();
        resultAttemptDTO1.setUserId(1l);
        resultAttemptDTO1.setLocalDateTime("22-01-2020");
        resultAttemptDTO1.setQuestion("Who is the president of the USA");
        resultAttemptDTO1.setAnswer("Trump");
        resultAttemptDTO1.setIsCorrect("true");


        ResultAttemptDTO resultAttemptDTO2 = new ResultAttemptDTO();
        resultAttemptDTO2.setUserId(1l);
        resultAttemptDTO1.setLocalDateTime("22-01-2020");
        resultAttemptDTO2.setAnswer("Peter Parker");
        resultAttemptDTO2.setQuestion("What's the real name of Spiderman");
        resultAttemptDTO2.setIsCorrect("true");

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

        List<ResultAttemptDTO> listDTO = Arrays.asList(resultAttemptDTO1, resultAttemptDTO2);

        List<ResultAttempt> listAttempt = Arrays.asList(resultAttempt1, resultAttempt2);

        when(triviaResultRepository.findByUserId(1)).thenReturn(listAttempt);

        when(triviaResultService.resultAttemptDTOList(listAttempt)).thenReturn(listDTO);

       final List<ResultAttemptDTO> resultAttempts = triviaResultService.getResults(1);

        assertEquals(resultAttempts.get(0).getAnswer(), resultAttemptDTO1.getAnswer());
        assertEquals(resultAttempts.get(1).getAnswer(), resultAttemptDTO2.getAnswer());

    }

    @Test void postTriviaResults () {
        ResultAttempt resultAttempt1 = new ResultAttempt();
        resultAttempt1.setAnswer("Trump");
        resultAttempt1.setQuestion("Who is the president of the USA");
        resultAttempt1.setCorrect(true);
        resultAttempt1.setUserId(1l);
        resultAttempt1.setAttemptId(1);
        resultAttempt1.setLocalDateTime(LocalDateTime.now());
        resultAttempt1.setId(1l);

        when(triviaResultRepository.save(resultAttempt1)).thenReturn(resultAttempt1);

        ResultAttempt resultAttempt = triviaResultService.postTriviaResults(resultAttempt1);

        assertEquals(resultAttempt.getAnswer(), resultAttempt1.getAnswer());

    }

    @MockBean(TriviaResultRepository.class)
    TriviaResultRepository triviaResultRepository() {
        return mock(TriviaResultRepository.class);
    }

    @MockBean(TriviaResultServiceImpl.class)
    TriviaResultService triviaResultService() {
        return mock(TriviaResultService.class);
    }
}
