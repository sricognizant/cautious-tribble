package org.micronaut.service;

import org.micronaut.domain.Response;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.ResultAttemptDTO;

import java.util.List;

public interface TriviaResultService {

    ResultAttempt postTriviaResults(ResultAttempt resultAttempt);

    List<ResultAttemptDTO> getResults(long userId);

    ResultAttemptDTO createResultAttemptDTO(ResultAttempt resultAttempt);

}
