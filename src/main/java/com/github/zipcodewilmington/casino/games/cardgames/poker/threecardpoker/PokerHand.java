package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;

import java.util.ArrayList;
import java.util.List;

public class PokerHand extends Hand implements PokerHandChecker {
    ThreeCardPokerHandRank handRank;

    public PokerHand(List<PlayingCard> cards) {
        this.cards = cards;
    }

    public PokerHand() {
        this.cards = new ArrayList<PlayingCard>();
    }

    public boolean hasPair(Hand hand) {
        return false;
    }

    public boolean hasFlush(Hand hand) {
        return false;
    }


    public boolean isStraightFlush(Hand hand) {
        return (hasThreeOfAKind(hand) && hasFlush(hand));
    }

    public boolean hasStraight(Hand hand){
        return false;
    }
    public boolean hasThreeOfAKind(Hand hand) {
        return false;
    }

    public ThreeCardPokerHandRank checkRank() {
        return null;
    }
    protected PlayingCard getHighestCard(Hand hand) {
        return null;
    }

}
