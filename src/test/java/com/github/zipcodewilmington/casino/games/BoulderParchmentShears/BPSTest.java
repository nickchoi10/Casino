package com.github.zipcodewilmington.casino.games.BoulderParchmentShears;

import com.github.zipcodewilmington.casino.games.BoulderParchmentShears.BPSEngine;
import org.junit.Assert;
import org.junit.Test;

public class BPSTest {

    @Test
    public void getWinner2PTest() {
        // Given
        String input1 = "boulder";
        String input2 = "parchment";
        String expected = "boulder";
        BPSEngine bps = new BPSEngine();
        // When
        String actual = bps.getWinner2P(input1, input2);
        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPvEWin() {
        String input1 = "boulder";
        String input2 = "parchment";
        BPSEngine bps = new BPSEngine();

        boolean actual = bps.pveWin(input1, input2, 0);
        boolean expected = true;
        Assert.assertFalse(actual);
    }

    @Test
    public void testPvPWin() {
        String input1 = "boulder";
        String input2 = "parchment";
        BPSEngine bps = new BPSEngine();

        boolean actual = bps.pvpWin(input1, input2, 0);
        boolean expected = true;
        Assert.assertFalse(actual);
    }
    
}
