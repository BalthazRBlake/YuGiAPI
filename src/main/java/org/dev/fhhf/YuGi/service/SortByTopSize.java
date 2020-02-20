package org.dev.fhhf.YuGi.service;

import org.dev.fhhf.YuGi.model.StandardDeck;

import java.util.Comparator;

public class SortByTopSize implements Comparator<StandardDeck> {
    public int compare(StandardDeck a, StandardDeck b){
        return b.getSize() - a.getSize();
    }
}
