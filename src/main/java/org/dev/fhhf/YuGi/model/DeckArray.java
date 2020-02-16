package org.dev.fhhf.YuGi.model;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DeckArray {
    private List<Long> cards;

    public DeckArray(){
    }

    public List<Long> getCards() {
        return cards;
    }

    public void setCards(List<Long> cards) {
        this.cards = cards;
    }
}
