package org.dev.fhhf.YuGi.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Map;

@Entity
@Table(name = "standard_deck")
public class StandardDeck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @Column(name = "deck_name", unique = true)
    @NotEmpty
    private String deckName;

    @NotEmpty
    @ElementCollection
    @MapKeyColumn(name="card_id")
    @Column(name="units")
    @CollectionTable(name="cards", joinColumns=@JoinColumn(name="units_id"))
    private Map<Long, Integer> cards;

    private int tier;

    public StandardDeck() {
    }

    public StandardDeck(long id) {
        this.id = id;
    }

    public StandardDeck(long id, @NotEmpty String deckName, @NotEmpty Map<Long, Integer> cards) {
        this.id = id;
        this.deckName = deckName;
        this.cards = cards;
    }

    public StandardDeck(long id, @NotEmpty String deckName, @NotEmpty Map<Long, Integer> cards, int tier) {
        this.id = id;
        this.deckName = deckName;
        this.cards = cards;
        this.tier = tier;
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

    @Override
    public String toString() {
        return "StandardDeck{" +
                "id=" + id +
                ", deckName='" + deckName + '\'' +
                ", cards=" + cards +
                ", tier=" + tier +
                '}';
    }
}
