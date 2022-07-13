package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

public enum ThreeCardPokerHandRank {
    STRAIGHT_FLUSH(1),
    THREE_OF_A_KIND(2),
    STRAIGHT(3),
    FLUSH(4),
    PAIR(5),
    HIGH_CARD(6);

    final int RANKING;

    ThreeCardPokerHandRank(int ranking) {
        this.RANKING = ranking;
    }

    public int getRanking() {
        return RANKING;
    }
}
