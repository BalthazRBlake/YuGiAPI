package org.dev.fhhf.YuGi.resources;

import org.dev.fhhf.YuGi.model.CardsList;
import org.dev.fhhf.YuGi.model.StandardDeck;
import org.dev.fhhf.YuGi.service.CardsList2MapService;
import org.dev.fhhf.YuGi.service.StandardDeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @GetMapping("/{card_id}")
    public StandardDeck getStandardDeckById(@PathVariable("card_id") long id){
        return standardDeckService.findStandardDeckById(id);
    }

    @PostMapping
    public StandardDeck addStandardDeck(@RequestBody CardsList cardsStandardDeck){
        StandardDeck standardDeck = new StandardDeck();

        /*System.out.println("JSON Cards");
        System.out.println(cardsStandardDeck.getDeckName());
        System.out.println(cardsStandardDeck.getCards());*/
        String deckName = cardsStandardDeck.getDeckName();
        Map<Long, Integer> cards = CardsList2MapService.fillCardsMap(cardsStandardDeck);

        standardDeck.setDeckName(deckName);
        standardDeck.setCards(cards);
        /*System.out.println("Standard to save");
        System.out.println(standardDeck);*/
        return standardDeckService.saveStandardDeck(standardDeck);
    }
}
