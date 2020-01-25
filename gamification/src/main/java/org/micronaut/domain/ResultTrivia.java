package org.micronaut.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

@NoArgsConstructor
@Data
@Introspected
public class ResultTrivia {
    private long userId;
    private int attemptId;
    private int isCorrect;
}
