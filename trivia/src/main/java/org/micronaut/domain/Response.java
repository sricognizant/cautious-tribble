package org.micronaut.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Introspected
@Setter
public class Response {

    private User user;

    private String question;

    private String choices;

    private String answer;

    private int correctAnswer;
}
