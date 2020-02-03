package org.micronaut.repository;

import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;
import org.micronaut.domain.Badge;
import org.micronaut.domain.BadgeCard;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@MicronautTest
public class BadgeCardRepositoryImplTest {

    @Inject
    BadgeCardRepository badgeCardRepository;

    @Test
    void testCrudOperations() {

        BadgeCard badgeCard1 = new BadgeCard(1l, Badge.BRONZE);
        BadgeCard badgeCard2 = new BadgeCard(1l, Badge.SILVER);
        BadgeCard badgeCard3 = new BadgeCard(1l, Badge.GOLD);

        badgeCardRepository.save(badgeCard1);
        badgeCardRepository.save(badgeCard2);
        badgeCardRepository.save(badgeCard3);

        assertEquals(3, badgeCardRepository.count());

        List<BadgeCard> badgeCardList = badgeCardRepository.findByUserId(1l);

        assertEquals(3, badgeCardList.size());

        BadgeCard badgeCard = badgeCardRepository.findById(1l).orElse(null);

        assertSame(1l, badgeCard.getBadgeId());
        assertSame(Optional.empty(), badgeCardRepository.findById(27l));

    }


}
