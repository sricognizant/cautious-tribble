package org.micronaut.domain;


import io.micronaut.core.annotation.Introspected;
import lombok.*;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Introspected
public class Result {

    private long userId;

    private int attemptId;

    private int isCorrect;
}
