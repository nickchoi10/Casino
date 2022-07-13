package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;

public class PokerHand extends Hand implements PokerHandChecker {
    ThreeCardPokerHandRank handRank;

    public boolean isPair(Hand hand) {
        return false;
    }

    public boolean isFlush(Hand hand) {
        return false;
    }


    public boolean isStraightFlush(Hand hand) {
        return (isThreeOfAKind(hand) && isFlush(hand));
    }

    public boolean isStraight(Hand hand){
        return false;
    }
    public boolean isThreeOfAKind(Hand hand) {
        return false;
    }

    protected PlayingCard getHighestCard(Hand hand) {
        return null;
    }

    protected PlayingCard getLowestCard(Hand hand) {
        return null;
    }
}
