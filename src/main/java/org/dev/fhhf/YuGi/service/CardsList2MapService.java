package org.dev.fhhf.YuGi.service;

import org.dev.fhhf.YuGi.model.CardsList;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CardsList2MapService {

    public static Map<Long, Integer> fillCardsMap(CardsList cards){

        Map<Long, Integer> cardsMap = new HashMap<>();

        for(long card : cards.getListCards()){
            int value = 0;
            long key = card;

            if(cardsMap.containsKey(card)){
                value = cardsMap.get(key);
                cardsMap.replace(key, ++value);
            } else {
                cardsMap.put(key, 1);
            }
        }
        return cardsMap;
    }
}
