package com.github.zipcodewilmington.casino.games.BoulderParchmentShears;

import com.github.zipcodewilmington.casino.games.BoulderParchmentShears.BPSEngine;
import org.junit.Assert;
import org.junit.Test;

public class BPSTest {

    @Test
    public void getWinner2PTest() {
        // Given
        String input1 = "boulder";
        String input2 = "parchem";
        String expected = "boulder";
        BPSEngine bps = new BPSEngine();

        // When
        String actual = bps.getWinner2P(input1, input2);

        // Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getWinner3PTest1(){
        String p1 = "boulder";
        String p2 = "parchment";
        String p3 = "shears";
        String expected = "draw";
        String actual = BPSEngine.getWinner3P(p1, p2, p3);
        Assert.assertEquals(actual, expected);
    }
    @Test
    public void getWinner3PTest2(){
        String p1 = "boulder";
        String p2 = "parchment";
        String p3 = "boulder";
        String expected = "parchment";
        String actual = BPSEngine.getWinner3P(p1, p2, p3);
        Assert.assertEquals(actual, expected);
    }
    
    
}
