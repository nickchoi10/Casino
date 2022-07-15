package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class RouletteTest {

    @Test
    public void spinWheelTest() {
        //Given
        Random rand = new Random(00);

        //When
        Integer r = rand.nextInt(37);

        //Then
        Integer expected = r;
        Assert.assertEquals(expected, r);

    }

    @Test
    public void playerBetOne() {

    }
}
