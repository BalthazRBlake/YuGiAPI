package org.dev.fhhf.YuGi.model;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardsList {

    private String deckName;

    private List<Long> cards;

    public CardsList(){
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public List<Long> getCards() {
        return cards;
    }

    public void setCards(List<Long> cards) {
        this.cards = cards;
    }
}
