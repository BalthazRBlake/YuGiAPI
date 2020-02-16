package org.dev.fhhf.YuGi.resources;

import org.dev.fhhf.YuGi.model.CardsList;
//import org.dev.fhhf.YuGi.model.MatchedDeck;
import org.dev.fhhf.YuGi.service.CardsList2MapService;
//import org.dev.fhhf.YuGi.service.MatchDecksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Map;

@RestController
public class YuGiResource {

    @Autowired
    CardsList2MapService cardsList2MapService;
    //@Autowired
    //MatchDecksService matchDecksService;

    @PostMapping("/top10decks")
    public Map<Long, Integer> cardList(@RequestBody CardsList cards){

        Map<Long, Integer> userCards = cardsList2MapService.fillCardsMap(cards);

        return userCards;
    }
}
