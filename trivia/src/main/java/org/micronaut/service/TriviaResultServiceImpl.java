package org.micronaut.service;

import org.micronaut.domain.ResultAttempt;
import org.micronaut.repository.TriviaResultRepository;

import javax.inject.Singleton;
import java.util.List;


@Singleton
public class TriviaResultServiceImpl implements TriviaResultService {

    private TriviaResultRepository triviaResultRepository;

    public TriviaResultServiceImpl(TriviaResultRepository triviaResultRepository) {
        this.triviaResultRepository = triviaResultRepository;
    }

    @Override
    public ResultAttempt postTriviaResults(ResultAttempt resultAttempt) {
        return triviaResultRepository.save(resultAttempt);
    }

    @Override
    public List<ResultAttempt> getResults(String name) {
        return triviaResultRepository.findByUserName(name);
    }



}
