package org.dev.fhhf.YuGi.service;

import org.dev.fhhf.YuGi.model.StandardDeck;

import java.util.List;

public interface StandardDeckService {

    public List<StandardDeck> standardDeckList();

    public StandardDeck findStandardDeckById(long id);

    public StandardDeck saveStandardDeck(StandardDeck standardDeck);

    public void deleteStandardDeck(long id);
}
