package org.micronaut.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Trivia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String question;

    private String choices;

    private int answer;

    public Trivia(String question, String choices, int answer) {
        this.question = question;
        this.choices = choices;
        this.answer = answer;
    }
}
