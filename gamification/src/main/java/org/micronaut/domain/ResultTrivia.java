package org.micronaut.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Introspected
public class ResultTrivia {
    private long userId;
    private int attemptId;
    private int isCorrect;
}
