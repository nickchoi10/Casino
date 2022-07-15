package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.games.cardgames.Hand;

public interface PokerHandChecker {

    boolean hasPair(Hand hand);

    boolean hasFlush(Hand hand);

    boolean hasStraight(Hand hand);

    boolean isStraightFlush(Hand hand);

    boolean hasThreeOfAKind(Hand hand);
}
