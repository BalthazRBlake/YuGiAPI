package org.dev.fhhf.YuGi.resources;

import org.dev.fhhf.YuGi.model.CardsList;
import org.dev.fhhf.YuGi.model.StandardDeck;
import org.dev.fhhf.YuGi.service.MatchDecksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class YuGiResource {

    @Autowired
    MatchDecksService matchDecksService;

    @PostMapping("/top10decks")
    public List<StandardDeck> cardList(@RequestBody CardsList cards){
        return matchDecksService.compareDecks(cards);
    }
}
