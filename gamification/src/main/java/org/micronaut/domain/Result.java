package org.micronaut.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.*;


@AllArgsConstructor
@Data
@Introspected
public class Result {
    private long userId;
    private int attemptId;
    private boolean isCorrect;
}
