package org.dev.fhhf.YuGi.service;

import org.dev.fhhf.YuGi.model.CardsList;
import org.dev.fhhf.YuGi.model.StandardDeck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchDecksService {

    @Autowired
    CardsList2MapService cardsList2MapService;
    @Autowired
    private StandardDeckService standardDeckService;

    public List<StandardDeck> compareDecks(CardsList cards){

        Map<Long, Integer> userCards = CardsList2MapService.fillCardsMap(cards);
        List<StandardDeck> standardDecks = standardDeckService.standardDeckList();
        List<StandardDeck> resultDecks = new ArrayList<>();


        for(StandardDeck sd : standardDecks) {
            int sizeTop = 0;
            Map<Long, Integer> sdCards = sd.getCards();
            Set<Long> standardKeys = sdCards.keySet();
            Map<Long, Integer> resultMapDeck = new HashMap<>();

            for (long standardKey : standardKeys) {

                if (userCards.containsKey(standardKey)) {
                    int value = sdCards.get(standardKey) - userCards.get(standardKey);

                    if (value <= 0) {
                        resultMapDeck.put(standardKey, 0);
                    } else {
                        resultMapDeck.put(standardKey, value);
                        sizeTop += value;
                    }
                } else {
                    resultMapDeck.put(standardKey, sdCards.get(standardKey));
                    sizeTop += sdCards.get(standardKey);
                }
            }
            sizeTop = sd.getSize() - sizeTop;
            StandardDeck cardsList = new StandardDeck(sd.getId(), sd.getDeckName(), resultMapDeck, sd.getTier(), sizeTop);
            resultDecks.add(cardsList);
        }
        return resultDecks;
    }
}