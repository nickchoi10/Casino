package com.github.zipcodewilmington.casino.games.roulette;

import java.util.Random;

public class RouletteWheel {

    public int spinWheel() {
        Random random = new Random();
        int spinResult = random.nextInt(38)+ 1; //Obtain a number from [1 - 36]
         try {
            if (spinResult != 0 && getRedEven(spinResult)) {
                System.out.println(spinResult + ", Red, " + "Even");
                return spinResult;
            } else if (getBlackOdd(spinResult)) {
                System.out.println(spinResult + ", Black, " + "Odd");
                return spinResult;
            } else if (getZero(spinResult)) {
                System.out.print(spinResult);
                return spinResult;
            } else if (spinResult == 37) {
                System.out.println("00");
                return spinResult;
            }
        } catch (Exception e) {
            System.out.println("Something went wrong. check again. Please try again.");
        };
         return spinResult;
    }
    public boolean getRedEven(int spinResult) {
        return spinResult % 2 == 0;
    }

    public boolean getBlackOdd(int spinResult) {
        return spinResult % 2 != 0;
    }
//
//    public boolean getDoubleZero(int spinResult) {
//        return spinResult == 37;
//    }

    public boolean getZero(int spinResult) {
        return spinResult == 0;
    }

}


