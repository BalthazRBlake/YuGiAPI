package org.dev.fhhf.YuGi.service;

import org.dev.fhhf.YuGi.model.CardsList;
//import org.dev.fhhf.YuGi.model.MatchedDeck;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CardsList2MapService {

    //@Autowired
    //private MatchedDeck matchedDeck;

    public static Map<Long, Integer> fillCardsMap(CardsList cards){

        Map<Long, Integer> cardsMap = new HashMap<>();

        for(long card : cards.getCards()){
            int value = 0;
            long key = card;

            if(cardsMap.containsKey(card)){
                value = cardsMap.get(key);
                cardsMap.replace(key, ++value);
            } else {
                cardsMap.put(key, 1);
            }
        }

        //matchedDeck.setCards(cardsMap);

        return cardsMap;
    }
}
