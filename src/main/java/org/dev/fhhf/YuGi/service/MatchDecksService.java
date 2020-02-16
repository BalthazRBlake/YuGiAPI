package org.dev.fhhf.YuGi.service;

import org.dev.fhhf.YuGi.model.StandardDeck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchDecksService {

    @Autowired
    private StandardDeckService standardDeckService;

    public List< Map<Long, Integer> > compareDecks(Map<Long, Integer> userCards){

        List<StandardDeck> standardDecks = standardDeckService.standardDeckList();
        List< Map<Long, Integer> > top10Decks = new ArrayList<>();

        for(StandardDeck sd : standardDecks) {

            Map<Long, Integer> sdCards = sd.getCards();
            Set<Long> standardKeys = sdCards.keySet();
            Map<Long, Integer> resultMapDeck = new HashMap<>();

            //System.out.println("Standard Deck1: " + standardDecks.getDeck1Cards());
            //System.out.println("User Deck: " + userCards.getCards());

            for (long standardKey : standardKeys) {

                if (userCards.containsKey(standardKey)) {
                    int value = sdCards.get(standardKey) - userCards.get(standardKey);

                    if (value <= 0) {
                        resultMapDeck.put(standardKey, 0);
                    } else {
                        resultMapDeck.put(standardKey, value);
                    }
                } else {
                    resultMapDeck.put(standardKey, sdCards.get(standardKey));
                }
            }
            top10Decks.add(resultMapDeck);
            System.out.println("Can build: " + resultMapDeck);
        }
        //resultDeck.setCards(resultMapDeck);
        //System.out.println("Can build: " + resultDeck.getCards());
        return top10Decks;
    }
}