package org.dev.fhhf.YuGi.service;

import org.dev.fhhf.YuGi.model.MatchedDeck;
import org.dev.fhhf.YuGi.standarddecks.StandardDecks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class MatchDecksService {

    @Autowired
    private StandardDecks standardDecks;
    @Autowired
    private MatchedDeck resultDeck;

    public MatchedDeck compareDecks(MatchedDeck userDeck){

        Set<Long> standardKeys =standardDecks.getDeck1Cards().keySet();
        Map<Long, Integer> resultMapDeck = new HashMap<>();

        System.out.println("Standard Deck1: " + standardDecks.getDeck1Cards());
        System.out.println("User Deck: " + userDeck.getCards());

        for(long standardKey : standardKeys){

            if(userDeck.getCards().containsKey(standardKey)){
                int value = standardDecks.getDeck1Cards().get(standardKey) - userDeck.getCards().get(standardKey);

                if(value <= 0){
                    resultMapDeck.put(standardKey, 0);
                } else {
                    resultMapDeck.put(standardKey, value);
                }
            }else{
                resultMapDeck.put(standardKey, standardDecks.getDeck1Cards().get(standardKey) );
            }
        }

        resultDeck.setCards(resultMapDeck);
        System.out.println("Can build: " + resultDeck.getCards());
        return resultDeck;
    }
}
