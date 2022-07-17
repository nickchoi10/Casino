package com.github.zipcodewilmington.casino.games.cardgames;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Dealer<T extends Hand, U extends Deck<PlayingCard>> {
    private T hand;
    private U deck;

    public Dealer(T hand, U deck) {
        this.hand = hand;
        this.deck = deck;
    }

    public T getHand() {
        return hand;
    }

    public void setHand(T hand) {
        this.hand = hand;
    }

    public U getDeck() {
        return deck;
    }

    public void setDeck(U deck) {
        this.deck = deck;
    }

    public List<PlayingCard> dealCards(int numberOfCards) throws IllegalArgumentException {
        List<PlayingCard> dealtCards = new ArrayList<>(numberOfCards);

        try {
            for (int i = 0; i < numberOfCards; i++) {
                dealtCards.add(deck.dealCard());
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("NOT ENOUGH CARDS IN THE DECK");
        }
        return dealtCards;
    }
}
