package org.dev.fhhf.YuGi.model;

import org.springframework.stereotype.Repository;

@Repository
public class DeckArray {
    private int[] cards;

    public DeckArray(){
    }

    public int[] getCards() {
        return cards;
    }

    public void setCards(int[] cards) {
        this.cards = cards;
    }
}
