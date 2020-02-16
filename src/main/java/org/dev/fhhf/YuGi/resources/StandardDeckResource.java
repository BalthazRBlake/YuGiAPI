package org.dev.fhhf.YuGi.resources;

import org.dev.fhhf.YuGi.model.StandardDeck;
import org.dev.fhhf.YuGi.service.StandardDeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/standardDecks")
public class StandardDeckResource {

    @Autowired
    StandardDeckService standardDeckService;

    @GetMapping
    public List<StandardDeck> getAllStandardDecks(){
        return  standardDeckService.standardDeckList();
    }

    @GetMapping("/{card_id}")
    public StandardDeck getStandardDeckById(@PathVariable("card_id") long id){
        return standardDeckService.findStandardDeckById(id);
    }

    @PostMapping
    public StandardDeck addStandardDeck(@RequestBody StandardDeck standardDeck){
        return standardDeckService.saveStandardDeck(standardDeck);
    }
}
