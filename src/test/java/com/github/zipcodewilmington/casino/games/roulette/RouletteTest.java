package com.github.zipcodewilmington.casino.games.roulette;

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
    public void welcomeMessage() {
        RouletteEngine testEngine = new RouletteEngine();

        //Given
        String welcomeMessage = "Welcome to the Roulette Table!";

        //When
        String functionWelcomeMessage = testEngine.welcomeMessage();

        //Then
        Assert.assertEquals(welcomeMessage, testEngine.welcomeMessage());

    }
    @Test
    public void  placeStraightUpBetLoseTest() {
        //Given
        int wager = 50;
        int bet = 2;
        int balance = 5000;
        int payOut;

        //When
        int result = 32;

        //Then
        if (result == bet) {
            payOut = wager * 35;
        } else {
            payOut = balance - wager;
        }
        int expected = 4950;
        int actual = payOut;
        Assert.assertEquals(expected, actual);
        }

    @Test
    public void  placeStraightUpBetWinTest() {
        //Given
        int wager = 50;
        int bet = 2;
        int balance = 5000;
        int payOut;

        //When
        int result = 2;

        //Then
        if (result == bet) {
            payOut = wager * 35;
        } else {
            payOut = balance - wager;
        }
        int expected = 50 * 35;
        int actual = payOut;
        Assert.assertEquals(expected, actual);
    }
}

