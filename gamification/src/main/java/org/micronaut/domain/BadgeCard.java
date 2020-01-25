package org.micronaut.domain;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@ToString
@EqualsAndHashCode
@Entity
@AllArgsConstructor
public class BadgeCard {

    @Id
    @GeneratedValue
    @Column(name = "BADGE_ID")
    private Long badgeId;

    private Long userId;
    private Badge badge;


    public BadgeCard() {
        this(null, null);
    }

    public BadgeCard(final Long userId, final Badge badge) {
        this(null, userId, badge);
    }

}
