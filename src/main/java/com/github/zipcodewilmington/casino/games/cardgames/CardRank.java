package com.github.zipcodewilmington.casino.games.cardgames;

public enum CardRank {
    ACE(1, "1"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K");
    public final int value;
    public final String strValue;

    CardRank(int value, String str) {
        this.value = value;
        this.strValue = str;
    }

    public int getValue() {
        return value;
    }

    public String getStrValue() {
        return strValue;
    }

}
