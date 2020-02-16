package org.dev.fhhf.YuGi.service;

import org.dev.fhhf.YuGi.model.StandardDeck;
import org.dev.fhhf.YuGi.repo.StandardDeckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardDeckServiceImpl implements StandardDeckService{

    @Autowired
    private StandardDeckRepo standardDeckRepo;

    @Override
    public List<StandardDeck> standardDeckList() {
        return standardDeckRepo.findAll();
    }

    @Override
    public StandardDeck findStandardDeckById(long id) {
        return standardDeckRepo.findById(id).get();
    }

    @Override
    public StandardDeck findStandardDeckByDeckName(String deckName) {
        return standardDeckRepo.findByDeckName(deckName).get();
    }

    @Override
    public StandardDeck saveStandardDeck(StandardDeck standardDeck) {
        return standardDeckRepo.save(standardDeck);
    }

    @Override
    public void deleteStandardDeck(StandardDeck standardDeck) {
        standardDeckRepo.delete(standardDeck);
    }
}
