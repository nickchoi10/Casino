package com.github.zipcodewilmington.casino.games.roulette;

import java.util.Random;
import java.util.Scanner;

public class RouletteEngine {

    public void spinWheel() {
        Random random = new Random();
        int spinResult = random.nextInt(38); //Obtain a number from [00 - 36]

        if (spinResult == 37) {
            System.out.println("00");
//        } else {
//            System.out.print(spinResult);
        }
        else if (spinResult %2 == 0) {
            System.out.println(spinResult + ", Red, Even");
        } else {
            System.out.println(spinResult + ", Black, Odd");


    }
    //The straight-up bet in roulette, is an inside bet (the corner bet is another example)
    // on a single number (or group of single numbers). It pays out 35:1.
//    public void placeStraightUpBet() {
//        Scanner playerBet = new Scanner(System.in);
//        if (spinWheel() ==  )
//
//        }






    }
}
