package org.micronaut.domain;


import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class GameStats {
    private Long userId;
    private int score;
    private Badge badge;
}
