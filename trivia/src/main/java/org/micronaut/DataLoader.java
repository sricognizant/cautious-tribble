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
            repository.save(new Trivia("Who is the president of the USA?",
                    "Obama|Trump|Lincon", 1));
            repository.save(new Trivia("What's the real name of Spiderman?",
                    "Peter Parker|Peter Pan|John Stark", 0));
            repository.save(new Trivia("What's the real name of Batman?",
                    "Bruce Wayne|Bruce Lee|Bane Bruce", 0));
            repository.save(new Trivia("Who is the founder of Apple Inc?",
                    "Steve Jobs|Steven Gerrard|Steel Jobs", 0));
            repository.save(new Trivia("Who is the founder of Microsoft?",
                    "Bill Gatsby|Ben Gates|Bill Gates", 2));
            repository.save(new Trivia("What is the real name of Superman?",
                    "Kent Clair|Kennedy Clerk|Clark Kent", 2));
            repository.save(new Trivia("What is 40 + 50?",
                    "90|100|300", 0));
            repository.save(new Trivia("What is 100 + 50?",
                    "110|150|50", 1));
            repository.save(new Trivia("What is 100 multiplied by 3?",
                    "400|300|200", 1));

        }
    }
}
