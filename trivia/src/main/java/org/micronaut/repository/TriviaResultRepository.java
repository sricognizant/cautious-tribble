package org.micronaut.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import org.micronaut.domain.ResultAttempt;

import java.util.List;

@Repository
public interface TriviaResultRepository extends CrudRepository<ResultAttempt, Long> {

    List<ResultAttempt> findByUserName(String userName);

}
