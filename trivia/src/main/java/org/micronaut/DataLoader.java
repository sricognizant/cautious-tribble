package org.micronaut;


import io.micronaut.context.annotation.Requires;
import io.micronaut.context.env.Environment;
import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import org.micronaut.domain.Trivia;
import org.micronaut.repository.TriviaRepository;

import javax.inject.Singleton;

@Singleton
@Requires(notEnv = Environment.TEST)
public class DataLoader implements ApplicationEventListener<ServerStartupEvent> {

    private TriviaRepository repository;

    public DataLoader(TriviaRepository repository) {
        this.repository = repository;
    }

    @Override
    public void onApplicationEvent(ServerStartupEvent event) {
        if (repository.count() == 0) {
            Trivia trivia1 = new Trivia("Who is the president of the USA",
                    "Obama|Trump|Lincon", 1);
            Trivia trivia2 = new Trivia("What's the real name of Spiderman",
                    "Peter Parker|Peter Pan|John Stark", 2);

            repository.save(trivia1);
            repository.save(trivia2);
        }
    }
}
