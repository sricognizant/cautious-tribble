package org.micronaut.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Introspected
public class ResultTrivia {
    private long userId;
    private int attemptId;
    private int isCorrect;
}
