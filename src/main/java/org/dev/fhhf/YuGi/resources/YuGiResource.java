package org.dev.fhhf.YuGi.resources;

import org.dev.fhhf.YuGi.model.CardsList;
import org.dev.fhhf.YuGi.model.MatchedDeck;
import org.dev.fhhf.YuGi.service.MapDeckArrayService;
import org.dev.fhhf.YuGi.service.MatchDecksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YuGiResource {

    @Autowired
    MapDeckArrayService mapDeckArray;
    @Autowired
    MatchDecksService matchDecksService;

    @PostMapping("/top10decks")
    public MatchedDeck cardList(@RequestBody CardsList cards){
        return matchDecksService.compareDecks( mapDeckArray.fillMatchedDeck(cards) );
    }
}
