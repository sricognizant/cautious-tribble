package org.micronaut.repository;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.micronaut.domain.ResultAttempt;
import org.micronaut.domain.User;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@MicronautTest
public class UserRepositoryImplTest {

    @Inject
    UserRepository userRepository;

    @Test
    void getUsers() {

       User user = new User();
       user.setName("joe");

        User user1 = new User();
        user.setName("john");


        userRepository.save(user);
        userRepository.save(user1);
        assertEquals(2, userRepository.count());

        Optional<User> user2 = userRepository.findByName("john");
        assertSame("john", user2.get().getName());
    }

}
