package com.github.zipcodewilmington.casino.games.cardgames;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Dealer<T extends Hand<? extends Card>, U extends Deck<? extends Card>> {
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



    public <S extends Card> List<S> dealCards(int numberOfCards, Class<S> cardType) throws IllegalArgumentException, ClassCastException {
        List<S> dealtCards = new ArrayList<>(numberOfCards);

        try {
            for (int i = 0; i < numberOfCards; i++) {
                try {
                    dealtCards.add(cardType.cast(deck.dealCard()));
                } catch (ClassCastException e) {
                    System.out.println("Wrong type of cards!");
                    throw new ClassCastException();
                }
            }
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("NOT ENOUGH CARDS IN THE DECK");
        }
        return dealtCards;
    }
}
