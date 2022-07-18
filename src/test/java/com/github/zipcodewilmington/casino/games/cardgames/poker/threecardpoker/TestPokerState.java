package com.github.zipcodewilmington.casino.games.cardgames.poker.threecardpoker;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestPokerState {

    @Test
    void testMainNextState() {
        PokerState expectedState = PokerState.BETTING;

        PokerState actualState = PokerState.MAIN_MENU.nextState();
        Assert.assertEquals(expectedState, actualState);
    }

    @Test
    void testBettingNextState() {
        PokerState expectedState = PokerState.DEALING;

        PokerState actualState = PokerState.BETTING.nextState();
        Assert.assertEquals(expectedState, actualState);
    }

    @Test
    void testDealingNextState() {
        PokerState expectedState = PokerState.PLAYCHOICE;

        PokerState actualState = PokerState.DEALING.nextState();
        Assert.assertEquals(expectedState, actualState);
    }

    @Test
    void testUserPlayNextState() {
        PokerState expectedState = PokerState.WINNERCALC;

        PokerState actualState = PokerState.USERPLAY.nextState();
        Assert.assertEquals(expectedState, actualState);
    }

    @Test
    void testNextState() {
        PokerState expectedState = PokerState.BETTING;

        PokerState actualState = PokerState.RESULT_MENU.nextState();
        Assert.assertEquals(expectedState, actualState);
    }
}