package org.dev.fhhf.YuGi.resources;

import io.swagger.annotations.ApiOperation;
import org.dev.fhhf.YuGi.model.CardsList;
import org.dev.fhhf.YuGi.model.StandardDeck;
import org.dev.fhhf.YuGi.service.CardsList2MapService;
import org.dev.fhhf.YuGi.service.StandardDeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/api/standardDecks")
public class StandardDeckResource {

    @Autowired
    private StandardDeckService standardDeckService;

    @GetMapping
    @ApiOperation(value = "returns all available Standard Decks",
            response = StandardDeck.class)
    public List<StandardDeck> getAllStandardDecks(){
        return  standardDeckService.standardDeckList();
    }

    @ApiOperation(value = "returns a Standard Decks",
            notes = "provide a Standard Deck Id",
            response = StandardDeck.class)
    @GetMapping("/{deck_id}")
    public ResponseEntity<StandardDeck> getStandardDeckById(@PathVariable("deck_id") long id){
        try {
            return ResponseEntity.ok(standardDeckService.findStandardDeckById(id));
        } catch (NoSuchElementException ex){
            return ResponseEntity.unprocessableEntity().eTag("No Standard Deck con Id: " + id).build();
        }
    }

    @ApiOperation(value = "adds a Standard Deck",
                notes = "provide an Array of cards size[20 - 30], with deckName, and optional Tier",
                response = StandardDeck.class)
    @PostMapping
    public ResponseEntity<StandardDeck> addStandardDeck(@RequestBody CardsList cardsStandardDeck, HttpServletRequest request){

        StandardDeck responseDeck = null;
        StandardDeck newStandardDeck = new StandardDeck(0);

        String deckName = cardsStandardDeck.getDeckName();
        int tier = cardsStandardDeck.getTier();
        int size = cardsStandardDeck.getCards().size();

        if(size < 20 || size > 30){
            return ResponseEntity.unprocessableEntity().eTag("El tamaño debe ser entre 20 y 30").build();
        }

        newStandardDeck.setDeckName(deckName);
        newStandardDeck.setTier(tier);
        newStandardDeck.setSize(size);

        Map<Long, Integer> cards = CardsList2MapService.fillCardsMap(cardsStandardDeck);
        newStandardDeck.setCards(cards);

        try{
            responseDeck = standardDeckService.findStandardDeckByDeckName(deckName);
            return ResponseEntity.badRequest().eTag("Ya existe un Standard Deck con Nombre: " + deckName).build();

        } catch (NoSuchElementException ex){

        }
        responseDeck = standardDeckService.saveStandardDeck(newStandardDeck);
        String sUri = request.getRequestURI() + "/" + String.valueOf(responseDeck.getId());
        URI uri = URI.create(sUri);
        return ResponseEntity.created(uri).body(responseDeck);
    }

    @ApiOperation(value = "updates a Standard Deck",
            notes = "provide Standard Deck Id, an Array of cards size[20 - 30], with deckName, and optional Tier",
            response = StandardDeck.class)
    @PutMapping("/{deck_id}")
    public ResponseEntity<StandardDeck> updateStandardDeck(@PathVariable("deck_id") long id, @RequestBody CardsList cardsStandardDeck){

        String deckName = cardsStandardDeck.getDeckName();

        try{
            StandardDeck optionalDeck = standardDeckService.findStandardDeckByDeckName(deckName);
            if(optionalDeck.getId() == id){

                Map<Long, Integer> cards = CardsList2MapService.fillCardsMap(cardsStandardDeck);
                int tier = cardsStandardDeck.getTier();
                int size = cardsStandardDeck.getCards().size();

                if(size < 20 || size > 30){
                    return ResponseEntity.unprocessableEntity().eTag("El tamaño debe ser entre 20 y 30").build();
                }

                StandardDeck standardDeck = new StandardDeck(id, deckName, cards, tier, size);

                standardDeckService.saveStandardDeck(standardDeck);

                return ResponseEntity.ok(standardDeck);
            }
        } catch (NoSuchElementException ex){

        }
        return ResponseEntity.badRequest().eTag("Deck no Existe o (Id / deckName) incorrecto").build();
    }

    @ApiOperation(value = "deletes a Standard Deck",
            notes = "provide a Standard Deck Id")
    @DeleteMapping("/{deck_id}")
    public void deleteStandardDeck(@PathVariable("deck_id") long id){
        StandardDeck standardDeck = new StandardDeck(id);
        standardDeckService.deleteStandardDeck(standardDeck);
    }
}
