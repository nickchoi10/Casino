package com.github.zipcodewilmington.casino.games.roulette;

import java.util.Scanner;

public class RouletteEngine {
    int spinResult;
    int bet;
    int playerBetOne;
    int money = 5000;


    //Explains rules/betting options of Roulette Game.
    public void startRouletteGame() {
        System.out.println("Welcome, account user, to Roulette! Please select a bet. Keep in mind that bets are limited\n" +
                "to 2 per round. Take a look at the Roulette Menu below and select a number to start having fun! \n" +
                "1.) Place a Straight Up Bet. This covers the ball landing on numbers 00, 0, and 1-36 " +
                "    (payout is 35:1). \n" +
                "2.) Place a Red/Even Bet. This covers the ball landing on numbers 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, \n" +
                "    22, 24, 26, 28, 30, 32, 34, 36 (payout is 1:1). \n" +
                "3.) Place a Black/Odd Bet. This covers the ball landing on numbers 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, \n" +
                "    21, 23, 25, 27, 29, 31, 33, 35 (payout is 1:1). \n" +
                "4.) Place a 1st Dozen Bet. This covers the ball landing on numbers 1 - 12 (payout is 2:1). \n" +
                "5.) Place a 2nd Dozen Bet. This covers the ball landing on numbers 13 - 24 (payout is 2:1). \n" +
                "6.) Place a 3rd Dozen Bet. This covers the ball landing on numbers 25 - 36 (payout is 2:1). \n");
    }
    // TODO Create 2 separate methods that take in user input for 1st bet and then 2nd bet
    // TODO Give users the option to select second bet in first method

    //user input for bet wager one (how much player wants to bet)
    public int betWagerOne() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What's your wager for your first bet? Remember, you're only allowed two!");
        int playerWagerOne = scan.nextInt();
        return playerWagerOne;
    }

    //user input for bet wager two (how much player wants to bet)
    public int betWagerTwo() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What's your wager for your second bet?");
        int playerWagerTwo = scan.nextInt();
        return playerWagerTwo;
    }

    // player bet input; return any (What specific bet the player chooses)
    public void playerBetOne() {
        System.out.println("What are betting on? For example, if you're betting on Odd, you can type, 'Odd'");
        Scanner playerBetOne = new Scanner(System.in);
        System.out.println("Your bet has been registered!");
    }

    public void playerBetTwo(String playerInput) {
        System.out.println("What are betting on? For example, if you're betting on Odd, you can type, 'Odd'");
        Scanner scan = new Scanner(System.in);
        System.out.println("Your bet has been registered!");
    }
}


    /* The straight-up bet in roulette, is an inside bet on a single number
     (or group of single numbers). It pays out 35:1.
     */
//    public void placeStraightUpBet(Integer input) {
//        for ()
//        }

    //Place a red/even bet.
    //TODO add win/lose feature.
//public void winRedEvenRoulette () {
//    //Bet is Red/Even
//     while (spinResult %2 == 0) {
//        for (int playerBetOne int spinResult)




//    }
//    }


    //Get user input; invoke firstBet method
        //spin wheel, compare bet to wheel
        //return something

//        if (playerBetOne() || playerBetTwo() == spinWheel()) {
//            return winLose();
//        } else {
//            System.out.println("Sorry! You lose!");
//        }
//    }


//    public int winLose() {
//        Scanner scan = new Scanner(System.in);
//        int playerBet = scan.nextInt();
//        if (playerBet == spinResult) {
//            int win = bet;
//            money += win;
//        } else {
//            int lose = bet;
//            money -= lose;
//        }
//        return money;
//    }
//}


//    public void run() {
//        String rules();
//        for (spinResult == playerBet) {
//        }
//    }
//
//}



