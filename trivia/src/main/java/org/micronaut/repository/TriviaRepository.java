package org.micronaut.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.micronaut.domain.Trivia;

import java.util.List;

@Repository
public interface TriviaRepository extends CrudRepository<Trivia, Long> {

    @Override
    List<Trivia> findAll();
}
