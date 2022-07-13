package com.github.zipcodewilmington.casino.games.roulette;

import java.util.Random;
import java.util.Scanner;

public class RouletteEngine {
    int spinResult;
    int bet;
    int money = 5000;

        public void run() {

        placeStraightUpBet();
        spinWheel();
        winLose();
    }



    //The straight-up bet in roulette, is an inside bet on a single number
    // (or group of single numbers). It pays out 35:1.
    public void placeStraightUpBet() {
        System.out.println("Place a bet!");
        Scanner scan = new Scanner(System.in);
        int playerBet = scan.nextInt();

        if (playerBet == spinResult) {
            System.out.println("Congrats! You win!");
        } else {
            System.out.println("Sorry! You lose!");
        }
    }

    public void spinWheel() {
        Random random = new Random();
        int spinResult = random.nextInt(38); //Obtain a number from [00 - 36]

        if (spinResult == 37) {
            System.out.println("00");
        } else if (spinResult % 2 == 0) {
            System.out.println(spinResult + ", Red, Even");
        } else {
            System.out.println(spinResult + ", Black, Odd");
        }
    }

    public int winLose() {
        Scanner scan = new Scanner(System.in);
        int playerBet = scan.nextInt();
        if (playerBet == spinResult) {
            int win = bet;
            money += win;
        } else {
            int lose = bet;
            money -= lose;
        }
        return money;
    }
}



//    public void run() {
//        String rules();
//        for (spinResult == playerBet) {
//        }
//    }
//
//}



