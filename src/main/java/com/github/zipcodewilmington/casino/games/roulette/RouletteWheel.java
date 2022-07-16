package com.github.zipcodewilmington.casino.games.roulette;

import java.util.Random;

public class RouletteWheel {

    public void spinWheel() {
        Random random = new Random();
        int spinResult = random.nextInt(38)+ 1; //Obtain a number from [1 - 36]
        if (spinResult !=0 && getRedEven(spinResult)) {
            System.out.println(spinResult + ", Red, " + "Even");
        }
        else if (getBlackOdd(spinResult)) {
            System.out.println(spinResult + ", Black, " + "Odd");
        }
        else if (getZero(spinResult)) {
            System.out.print(spinResult);
        }
        else if (getDoubleZero(spinResult)) {
            System.out.println("00");
        }
    }
    public boolean getRedEven(int spinResult) {
        return spinResult % 2 == 0;
    }

    public boolean getBlackOdd(int spinResult) {
        return spinResult % 2 != 0;
    }

    public boolean getDoubleZero(int spinResult) {
        return spinResult == 37;
    }

    public boolean getZero(int spinResult) {
        return spinResult == 0;
    }

}


