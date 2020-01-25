package org.micronaut.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class ScoreCard {

    @Id
    @GeneratedValue
    @Column(name = "CARD_ID")
    private Long cardId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ATTEMPT_ID")
    private int attemptId;

    @Column(name = "SCORE_TS")
    private long scoreTimestamp;

    @Column(name = "SCORE")
    private int score;


    public ScoreCard(Long cardId, Long userId, int attemptId, int score) {
        this.cardId = cardId;
        this.userId = userId;
        this.attemptId = attemptId;
        this.scoreTimestamp = System.currentTimeMillis();
        this.score = score;
    }

    public ScoreCard(Long userId, int attemptId, int score) {
        this.userId = userId;
        this.attemptId = attemptId;
        this.scoreTimestamp = System.currentTimeMillis();
        this.score = score;
    }
}
