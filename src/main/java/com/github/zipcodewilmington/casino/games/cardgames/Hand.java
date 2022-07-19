package com.github.zipcodewilmington.casino.games.cardgames;

import java.util.ArrayList;
import java.util.List;

public class Hand<T extends Card>{
    protected List<T> cards;


    public Hand() {
        cards = new ArrayList<>();
    }


    public Hand(List<T> cards) {
        this.cards = cards;
    }


    public T getCard(int index) {
        return cards.get(index);
    }


    public T removeAndReturnCard(int index) {
        T card = cards.get(index);
        cards.remove(card);
        return card;
    }

    public void removeCard(T card) {
        cards.remove(card);
    }

    public List<T> getCards() {
        return cards;
    }


    public void clearHand() {
        cards.clear();
    }


    public int getNumberOfCards() {
        return cards.size();
    }


    public void swapCard(T card, int index) {
        try {
            cards.set(index, card);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no card at that position!");
        }
    }

    // TODO: call playing card toString or printCard methods instead
    public void printHand() {
        for (T card : cards) {
            System.out.print(card.toString());
        }
    }

}
