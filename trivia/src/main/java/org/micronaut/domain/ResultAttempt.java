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

    private String question;

    private String answer;

    private boolean result;

    public ResultAttempt(User user, String question, String answer, boolean result) {
        this.user = user;
        this.question = question;
        this.answer = answer;
        this.result = result;
    }

}
