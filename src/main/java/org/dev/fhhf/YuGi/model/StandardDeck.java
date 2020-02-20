package org.dev.fhhf.YuGi.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Map;

@Entity
@Table(name = "standard_deck")
public class StandardDeck implements Serializable {
    private static final long serialVersionUID = 1L;

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

    @Column(name="size")
    private Integer size;

    public StandardDeck() {
        size = 0;
    }

    public StandardDeck(long id) {
        this.id = id;
    }

    public StandardDeck(@NotEmpty String deckName) {
        this.deckName = deckName;
    }

    public StandardDeck(@NotEmpty String deckName, @NotEmpty Map<Long, Integer> cards, int tier, int size) {
        this.deckName = deckName;
        this.cards = cards;
        this.tier = tier;
        this.size = size;
    }

    public StandardDeck(long id, @NotEmpty String deckName, @NotEmpty Map<Long, Integer> cards, int tier, int size) {
        this.id = id;
        this.deckName = deckName;
        this.cards = cards;
        this.tier = tier;
        this.size = size;
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

    public int getSize() {
        if(size == null) return 0;
        return size;
    }

    public void setSize(Integer size) {
        if(size == null) size = 0;
        this.size = size;
    }

    @Override
    public String toString() {
        return "StandardDeck{" +
                "id=" + id +
                ", deckName='" + deckName + '\'' +
                ", cards=" + cards +
                ", tier=" + tier +
                ", size=" + size +
                '}';
    }
}
