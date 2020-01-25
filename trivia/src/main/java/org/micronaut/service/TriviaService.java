package org.micronaut.service;

import org.micronaut.domain.Trivia;
import org.micronaut.domain.User;

public interface TriviaService {

    Trivia getTrivia(int count);

    User checkUser(User user);

}
