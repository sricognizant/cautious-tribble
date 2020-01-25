package org.micronaut.domain;


import io.micronaut.core.annotation.Introspected;
import lombok.*;

@AllArgsConstructor
@Introspected
@Data
public class Result {

    private long userId;

    private int attemptId;

    private int isCorrect;
}
