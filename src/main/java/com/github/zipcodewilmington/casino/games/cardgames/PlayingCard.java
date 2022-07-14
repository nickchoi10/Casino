package com.github.zipcodewilmington.casino.games.cardgames;

public class PlayingCard implements Comparable<PlayingCard>{
    private final CardSuit SUIT;
    private final CardRank RANK;

    public PlayingCard(CardSuit suit, CardRank rank) {
        this.SUIT = suit;
        this.RANK = rank;
    }

    public CardSuit getSuit() {
        return SUIT;
    }

    public CardRank getRank() {
        return RANK;
    }

    public boolean equals(PlayingCard card) {
        if (this.SUIT == card.SUIT && this.RANK == card.RANK) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(PlayingCard c) {
        return this.getRank().getValue() - c.getRank().getValue();
    }

    // TODO: Add console graphic representation of card
    public void printCard() {}

}

