package org.micronaut.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;


@ToString
@EqualsAndHashCode
@Entity
@Getter
@Setter
public final class ResultAttempt {

    /*@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;*/

    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private LocalDateTime localDateTime;
    private String question;
    private String answer;
    private int attemptId;
    private boolean isCorrect;


    public ResultAttempt(Long userId, LocalDateTime localDateTime, String question, String answer, int attemptId,
                         boolean isCorrect) {
        this.userId = userId;
        this.localDateTime = localDateTime;
        this.question = question;
        this.answer = answer;
        this.attemptId = attemptId;
        this.isCorrect = isCorrect;
    }

    public ResultAttempt() {
    }
}
