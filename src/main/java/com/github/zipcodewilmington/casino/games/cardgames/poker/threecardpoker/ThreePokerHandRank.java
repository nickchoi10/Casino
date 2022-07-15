package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

public enum ThreePokerHandRank {
    STRAIGHT_FLUSH(600),
    THREE_OF_A_KIND(500),
    STRAIGHT(400),
    FLUSH(300),
    PAIR(200),
    HIGH_CARD(100);

    final int POINTS;

    ThreePokerHandRank(int ranking) {
        this.POINTS = ranking;
    }

    public int getPoints() {
        return POINTS;
    }
}
