package org.micronaut.service;

import org.micronaut.domain.ResultAttempt;

import java.util.List;

public interface TriviaResultService {

    ResultAttempt postTriviaResults(ResultAttempt resultAttempt);

    List<ResultAttempt> getResults(String name);

}
