package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.*;

public class ThreeCardPokerEngine {
    private Deck<PlayingCard> deck;


    public ThreeCardPokerEngine() {
        deck = new StandardDeck();
    }

    // Deals 3 cards to specified player from deck.
    // TODO: PlayerInterface is temporary filler for PokerPlayer
    protected void dealCards(PlayerInterface player){}

    // Returns positive int if hand1 is greater than hand2, 0 if equal, negative if less
    public int compareHands(Hand hand1, Hand hand2) {
        return 0;
    }

    public int getHandPointValue(PokerHand hand) {
        ThreePokerHandRank rank = hand.getRank();
        int points = 0;
        int highestCardVal = hand.getHighestCard(hand).getRank().getValue();
        switch (rank) {
            case STRAIGHT_FLUSH:
                points += ThreePokerHandRank.STRAIGHT_FLUSH.POINTS + highestCardVal;
                return points;
            case THREE_OF_A_KIND:
                points += ThreePokerHandRank.THREE_OF_A_KIND.POINTS + highestCardVal;
                return points;
            case STRAIGHT:
                points += ThreePokerHandRank.STRAIGHT.POINTS + highestCardVal;
                return points;
            case FLUSH:
                points += ThreePokerHandRank.FLUSH.POINTS + highestCardVal;
                return points;
            case PAIR:
                return ThreePokerHandRank.PAIR.getPoints();
            case HIGH_CARD:
                return highestCardVal;
        }
        return points;
    }

}
