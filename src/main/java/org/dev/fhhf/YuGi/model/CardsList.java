package org.dev.fhhf.YuGi.model;

import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Map;

@Repository
public class CardsList {

    private long id;
    private String deckName;
    private List<Long> listCards;
    private Map<Long, Integer> cards;
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

    public List<Long> getListCards() {
        return listCards;
    }

    public void setListCards(List<Long> cards) {
        this.listCards = cards;
    }

    public Map<Long, Integer> getCards() {
        return cards;
    }

    public void setCards(Map<Long, Integer> cards) {
        this.cards = cards;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }
}
