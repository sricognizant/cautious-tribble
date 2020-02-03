package org.micronaut.domain;


import lombok.*;


@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class LeaderBoard {

    private String userId;
    private String totalScore;

}
