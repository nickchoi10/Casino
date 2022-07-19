package com.github.zipcodewilmington.casino.games.cardgames;

public enum CardSuit {
    DIAMONDS('\u2666'),
    SPADES('\u2660'),
    HEARTS('\u2665'),
    CLUBS('\u2663');

    char unicode;

    CardSuit(char unicode) {
        this.unicode = unicode;
    }

    public char getUnicode() {
        return this.unicode;
    }
}
