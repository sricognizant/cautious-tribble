package org.micronaut.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Introspected
public class Result {
    private long userId;
    private int attemptId;
    private boolean isCorrect;
}
