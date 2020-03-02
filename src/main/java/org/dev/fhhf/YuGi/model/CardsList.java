package org.dev.fhhf.YuGi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ApiModel(description = "Deck Array input model Object")
public class CardsList {

    private long id;
    @ApiModelProperty(required = true, example = "Super Deck")
    private String deckName;
    @ApiModelProperty(required = true, notes = "Array of cards size (20 - 30)")
    private List<Long> cards;
    @ApiModelProperty(example = "1", notes = "Optional parameter Deck Strength")
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
