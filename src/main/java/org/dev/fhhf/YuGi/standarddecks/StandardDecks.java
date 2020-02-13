package org.dev.fhhf.YuGi.standarddecks;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StandardDecks {

    //private int[] deck1 = {1, 3, 4, 50, 40, 10, 20, 30, 30};
    private Map<Long, Integer> deck1Cards = new HashMap<>();

    public StandardDecks(){
        long[] cards = {35191415, 35191415, 7084129, 7084129, 7084129, 46986414, 46986414, 46986414, 47222536, 47222536, 47222536, 2314238, 73616671, 1784686, 7922915, 7922915, 7922915, 98414735, 98414735, 82382815, 73452089, 98502113};
        for(long card : cards){
            int value = 0;
            long key = card;

            if(deck1Cards.containsKey(card)){
                value = deck1Cards.get(key);
                deck1Cards.replace(key, ++value);
            } else {
                deck1Cards.put(key, 1);
            }
        }
    }
    /*public int[] getDeck1() {
        return deck1;
    }

    public void setDeck1(int[] deck1) {
        this.deck1 = deck1;
    }*/

    public Map<Long, Integer> getDeck1Cards() {
        return deck1Cards;
    }

    public void setDeck1Cards(Map<Long, Integer> deck1Cards) {
        this.deck1Cards = deck1Cards;
    }
}
