package org.micronaut.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResultAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    private Long quizId;

    private String answered;

    private boolean result;

    public ResultAttempt(User user, Long quizId, String answered, boolean result) {
        this.user = user;
        this.quizId = quizId;
        this.answered = answered;
        this.result = result;
    }

}
