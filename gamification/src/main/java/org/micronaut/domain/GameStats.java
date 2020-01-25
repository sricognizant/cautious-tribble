package org.micronaut.domain;


import lombok.*;


@AllArgsConstructor
@Data
public class GameStats {
    private Long userId;
    private int score;
    private Badge badge;
}
