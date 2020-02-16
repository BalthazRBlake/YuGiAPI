package org.dev.fhhf.YuGi.resources;

import org.dev.fhhf.YuGi.model.CardsList;
import org.dev.fhhf.YuGi.model.StandardDeck;
import org.dev.fhhf.YuGi.service.CardsList2MapService;
import org.dev.fhhf.YuGi.service.StandardDeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/standardDecks")
public class StandardDeckResource {

    @Autowired
    private StandardDeckService standardDeckService;
    @Autowired
    CardsList2MapService cardsList2MapService;

    @GetMapping
    public List<StandardDeck> getAllStandardDecks(){
        return  standardDeckService.standardDeckList();
    }

    @GetMapping("/{deck_id}")
    public StandardDeck getStandardDeckById(@PathVariable("deck_id") long id){
        return standardDeckService.findStandardDeckById(id);
    }

    //@RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
    @PostMapping
    public ResponseEntity<StandardDeck> addStandardDeck(@RequestBody CardsList cardsStandardDeck, HttpServletRequest request){

        StandardDeck responseDeck = null;
        StandardDeck standardDeck = new StandardDeck();

        String deckName = cardsStandardDeck.getDeckName();
        Map<Long, Integer> cards = CardsList2MapService.fillCardsMap(cardsStandardDeck);
        int tier = cardsStandardDeck.getTier();

        standardDeck.setDeckName(deckName);
        standardDeck.setCards(cards);
        standardDeck.setTier(tier);

        try{
            responseDeck = standardDeckService.findStandardDeckByDeckName(deckName);
            String sUri = request.getRequestURI() + "/" + String.valueOf(responseDeck.getId());
            URI uri = URI.create(sUri);
            return ResponseEntity.created(uri).body(responseDeck);
        } catch (NoSuchElementException ex){

        }
        responseDeck = standardDeckService.saveStandardDeck(standardDeck);
        String sUri = request.getRequestURI() + "/" + String.valueOf(responseDeck.getId());
        URI uri = URI.create(sUri);
        return ResponseEntity.created(uri).body(responseDeck);
    }

    @PutMapping("/{deck_id}")
    public StandardDeck updateStandardDeck(@PathVariable("deck_id") long id, @RequestBody CardsList cardsStandardDeck){

        String deckName = cardsStandardDeck.getDeckName();
        Map<Long, Integer> cards = CardsList2MapService.fillCardsMap(cardsStandardDeck);
        int tier = cardsStandardDeck.getTier();

        StandardDeck standardDeck = new StandardDeck(id, deckName, cards, tier);

        return standardDeckService.saveStandardDeck(standardDeck);
    }

    @DeleteMapping("/{deck_id}")
    public void deleteStandardDeck(@PathVariable("deck_id") long id){
        StandardDeck standardDeck = new StandardDeck(id);
        standardDeckService.deleteStandardDeck(standardDeck);
    }
}
