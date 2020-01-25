package org.micronaut.domain;

import io.micronaut.core.annotation.Introspected;
import lombok.*;

@RequiredArgsConstructor
@AllArgsConstructor
@Introspected
@Data
public class ResultAttemptDTO {

    private long userId;

    private String localDateTime;

    private String question;

    private String answer;

    private String isCorrect;

}
