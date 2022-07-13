package com.github.zipcodewilmington.casino.games.roulette;

import java.util.Random;

public class RouletteEngine {

    public void spinWheel() {
        Random random = new Random();

        //Obtain a number from [00 - 36]
        int spinResult = random.nextInt(38);
        if (spinResult == 37) {
            System.out.println("00");
        } else {
            System.out.print(spinResult);
        }

    }
    //Gambler will
    public void placeStraightUpBet() {






    }
}
