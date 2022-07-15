package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.cardgames.*;

import java.util.Collections;
import java.util.List;

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
        int highestCardVal = hand.getHighestCard(hand, false).getRank().getValue();
        switch (rank) {
            case STRAIGHT_FLUSH:
                points += ThreePokerHandRank.STRAIGHT_FLUSH.POINTS + highestCardVal;
                return points;
            case THREE_OF_A_KIND:
                if (hand.getHighestCard(hand, false).getRank() == CardRank.ACE) {
                    highestCardVal = 14;
                }
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

    public PokerPlayer flushTieBreaker(PokerPlayer player1, PokerPlayer player2) throws IllegalArgumentException {
        PokerHand hand1 = player1.getHand();
        PokerHand hand2 = player2.getHand();
        if (hand1.getRank() != ThreePokerHandRank.FLUSH || hand2.getRank() != ThreePokerHandRank.FLUSH) {
            throw new IllegalArgumentException("Both hands must be a flush");
        }
        if (!hand1.isFullHand(hand1.getCards()) || !hand2.isFullHand(hand2.getCards())) {
            throw new IllegalArgumentException("Both players must have full hands");
        }
//        Collections.sort(hand1.getCards());
//        Collections.sort(hand2.getCards());
        while (hand1.getNumberOfCards() > 0 && hand2.getNumberOfCards() > 0) {
            PlayingCard card1 = hand1.getHighestCard(hand1, true);
            PlayingCard card2 = hand2.getHighestCard(hand2, true);

            if (card1.getRank().getValue() > card2.getRank().getValue()) {
                return player1;
            } else if (card2.getRank().getValue() > card1.getRank().getValue()) {
                return player2;
            }
            hand1.removeCard(card1);
            hand2.removeCard(card2);
        }

        return null;

//        if (hand1.getCard(0).getRank() == CardRank.ACE && hand2.getCard(0).getRank() != CardRank.ACE) {
//            return player1;
//        } else if (hand2.getCard(0).getRank() == CardRank.ACE && hand1.getCard(0).getRank() != CardRank.ACE) {
//            return player2;
//        }
//
//        for (int i = hand1.getNumberOfCards() - 1; i >= 0; i ++) {
//            if (hand1.getCard(i).getRank().getValue() > (hand2.getCard(i)).getRank().getValue()){
//                return player1;
//            } else if (hand1.getCard(i).getRank().getValue() > (hand2.getCard(i)).getRank().getValue())
    }

    public PokerPlayer pairTieBreaker(PokerPlayer player1, PokerPlayer player2) throws IllegalArgumentException {
//        if (hand1.getRank() != ThreePokerHandRank.PAIR || hand2.getRank() != ThreePokerHandRank.PAIR) {
//            throw new IllegalArgumentException("Both hands must be a flush");
//        }
        return null;
    }

    public PokerPlayer highCardTieBreaker(PokerPlayer player1, PokerPlayer player2) throws IllegalArgumentException {
        return null;
    }

}
