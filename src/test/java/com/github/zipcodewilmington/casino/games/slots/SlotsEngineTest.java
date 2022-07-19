package com.github.zipcodewilmington.casino.games.slots;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SlotsEngineTest {

    @Test
    void isPlaying() {
    }

    @Test
    void beginMessage() {
        SlotsEngine s = new SlotsEngine();
        String actual = s.beginMessage();
        String expected = "Hello, welcome to the StarDust's Slot Game\n" +
                "Match 2 numbers across the board, you win 1/4 bet amount!\n" +
                "Match 3 numbers across the board, you win your bet amount!\n" +
                "Triple 7 in middle row is *JACKPOT*. You win 500x bet amount!\n" +
                "Good Luck!";
        Assert.assertEquals(actual,expected);
    }

    @Test
    void spinSlot() {
        SlotsEngine slotEngine = new SlotsEngine();
        Random rand =new Random(1);
        slotEngine.setRand(rand);

        int r = rand.nextInt(9)+1;
        List<Integer> result = slotEngine.spinSlot();
        List<Integer> expected = new ArrayList<>(Arrays.asList(2, 2, 7, 9, 5, 6, 2, 2, 2));

        Assert.assertEquals(expected, result);
    }

    @Test
    void displayBoard() {
    }

    @Test
    void clearArray() {
    }

    @Test
    void beginningBalance() {
    }

    @Test
    void currentBalance() {
    }

    @Test
    void jackPotCondition() {
    }
}