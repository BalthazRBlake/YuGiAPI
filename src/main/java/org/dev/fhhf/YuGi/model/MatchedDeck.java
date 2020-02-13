package org.dev.fhhf.YuGi.model;

import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class MatchedDeck {

    private Map<Long, Integer> cards;

    public Map<Long, Integer> getCards() {
        return cards;
    }

    public void setCards(Map<Long, Integer> cards) {
        this.cards = cards;
    }
}
