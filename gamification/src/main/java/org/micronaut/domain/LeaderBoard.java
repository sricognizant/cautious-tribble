package org.micronaut.domain;


import lombok.*;


@AllArgsConstructor
@Data
public class LeaderBoard {

    private String userId;
    private String totalScore;

}
