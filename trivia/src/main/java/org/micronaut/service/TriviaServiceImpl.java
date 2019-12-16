package org.micronaut.service;

import org.micronaut.domain.Trivia;
import org.micronaut.repository.TriviaRepository;

import javax.inject.Singleton;
import java.util.List;
import java.util.Random;


@Singleton
public class TriviaServiceImpl implements TriviaService {

    TriviaRepository triviaRepository;

    public TriviaServiceImpl(TriviaRepository triviaRepository) {
        this.triviaRepository = triviaRepository;
    }

    @Override
    public Trivia getTrivia() {
        List<Trivia> triviaList = triviaRepository.findAll();
        return triviaList.get(new Random().nextInt(triviaList.size()));
    }
}
