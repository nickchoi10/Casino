package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.games.cardgames.Hand;

public interface PokerHandChecker {

    boolean isPair(Hand hand);

    boolean isFlush(Hand hand);

    boolean isStraight(Hand hand);

    boolean isStraightFlush(Hand hand);

    boolean isThreeOfAKind(Hand hand);
}
