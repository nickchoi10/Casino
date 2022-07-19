package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import com.github.zipcodewilmington.casino.games.cardgames.Hand;
import com.github.zipcodewilmington.casino.games.cardgames.PlayingCard;

public interface PokerHandChecker {

    boolean hasPair(Hand<PlayingCard> hand);

    boolean hasFlush(Hand<PlayingCard> hand);

    boolean hasStraight(Hand<PlayingCard> hand);

    boolean isStraightFlush(Hand<PlayingCard> hand);

    boolean hasThreeOfAKind(Hand<PlayingCard> hand);
}
