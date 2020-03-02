package org.dev.fhhf.YuGi.resources;

import io.swagger.annotations.ApiOperation;
import org.dev.fhhf.YuGi.model.CardsList;
import org.dev.fhhf.YuGi.model.StandardDeck;
import org.dev.fhhf.YuGi.service.MatchDecksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class YuGiResource {

    @Autowired
    MatchDecksService matchDecksService;

    @ApiOperation(value = "returns the Top 10 Matched Standard Decks",
    notes = "provide an Array of Cards size[n]",
    response = StandardDeck.class)
    @PostMapping("/api/top10decks")
    public ResponseEntity<List<StandardDeck>> cardList(@RequestBody CardsList cards){

        int size = cards.getCards().size();
        if(size < 20){
            return ResponseEntity.unprocessableEntity().eTag("la Deck debe contener al menos 20 cartas").build();
        }

        List<StandardDeck> allResults = matchDecksService.compareDecks(cards);

        int n = allResults.size() > 9 ? 9 : allResults.size();

        return ResponseEntity.ok( allResults.subList(0, n) );
    }
}
