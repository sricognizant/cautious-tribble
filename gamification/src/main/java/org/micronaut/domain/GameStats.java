package org.micronaut.domain;


import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class GameStats {
    private Long userId;
    private int score;
    private Badge badge;
}
