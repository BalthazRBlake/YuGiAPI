package org.dev.fhhf.YuGi.model;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CardsList {

    private long id;
    private String deckName;
    private List<Long> cards;
    private int tier;

    public CardsList(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

}
