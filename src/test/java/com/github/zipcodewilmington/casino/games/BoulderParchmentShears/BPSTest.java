package com.github.zipcodewilmington.casino.games.BoulderParchmentShears;

import com.github.zipcodewilmington.casino.games.BoulderParchmentShears.BPSEngine;
import org.junit.Assert;
import org.junit.Test;

public class BPSTest {

    @Test
    public void getWinnerTest2P() {
        // Given
        String input1 = "rock";
        String input2 = "scissor";
        String expected = "rock";
        BPSEngine bps = new BPSEngine();

        // When
        String actual = bps.getWinner2P(input1, input2);

        // Then
        Assert.assertEquals(expected, actual);
    }


    
    
    
}
