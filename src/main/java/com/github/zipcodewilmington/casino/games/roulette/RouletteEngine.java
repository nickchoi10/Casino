package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.Account;

import java.util.Scanner;

public class RouletteEngine {
    int spinResult;
    int bet;
    int playerBetOne;
    //int money = 5000; don't think i need this
    private String accountName;
    private String name;
    private String password;
    private int balance;
    Account userAcct = new Account("O", "O", "O", 2000);



    //Explains rules/betting options of Roulette Game.
    public void startRouletteGame() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Roulette Table! Please enter your user name.");
        String userName = scan.nextLine();
        userAcct = Account.getAccount(userName);
        System.out.println("Welcome, " + userName + ", to Roulette! Please select a bet. Keep in mind that bets are limited\n" +
                "to 1 per round. Take a look at the Roulette Menu below and select a number to start having fun! \n" +
                "1.) Place a Straight Up Bet. This covers the ball landing on numbers 00, 0, and 1-36 " +
                "    (payout is 35:1). \n" +
                "2.) Place a Red/Even Bet. This covers the ball landing on numbers 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, \n" +
                "    22, 24, 26, 28, 30, 32, 34, 36 (payout is 1:1). \n" +
                "3.) Place a Black/Odd Bet. This covers the ball landing on numbers 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, \n" +
                "    21, 23, 25, 27, 29, 31, 33, 35 (payout is 1:1). \n" +
                "4.) Place a 1st Dozen Bet. This covers the ball landing on numbers 1 - 12 (payout is 2:1). \n" +
                "5.) Place a 2nd Dozen Bet. This covers the ball landing on numbers 13 - 24 (payout is 2:1). \n" +
                "6.) Place a 3rd Dozen Bet. This covers the ball landing on numbers 25 - 36 (payout is 2:1). \n" +
                "Select your bet from the menu. \n");
        if (scan.nextInt() == 1) {
            System.out.println("What's your wager for your bet? Remember, " + userName + ", you're only allowed one!");
            int wager = scan.nextInt();
            System.out.println("What's your bet? Pick a number, any number.");
            int bet = scan.nextInt();
            placeStraightUpBet(wager, bet, balance);
        }
        if (scan.nextInt() == 2) {
            System.out.println("What's your wager for your bet? Remember, " + userName + ", you're only allowed one!");
            int wager = scan.nextInt();
            //System.out.println("What's your bet? Select 1 for a RED or EVEN.");
            int bet = scan.nextInt();
            // System.out.println("You chose)
            placeRedEvenBet(wager, bet, balance);
        }
        if (scan.nextInt() == 3) {
            System.out.println("What's your wager for your bet? Remember, " + userName + ", you're only allowed one!");
            int wager = scan.nextInt();
            int bet = scan.nextInt();
            placeBlackOddBet(wager, bet, balance);
        }
        if (scan.nextInt() == 4) {
            System.out.println("What's your wager for your bet? Remember, " + userName + ", you're only allowed one!");
            int wager = scan.nextInt();
            int bet = scan.nextInt();
            placeFirstDozenBet(wager, bet, balance);
        }
        if (scan.nextInt() == 4) {
            System.out.println("What's your wager for your bet? Remember, " + userName + ", you're only allowed one!");
            int wager = scan.nextInt();
            int bet = scan.nextInt();
            placeSecondDozenBet(wager, bet, balance);

        if (scan.nextInt() == 4) {
            System.out.println("What's your wager for your bet? Remember, " + userName + ", you're only allowed one!");
            int wager = scan.nextInt();
            int bet = scan.nextInt();
            placeThirdDozenBet(wager, bet, balance);

            }
        }
    }


    //user input for bet wager one (how much player wants to bet)
    public int betWagerOne() {
        Scanner scan = new Scanner(System.in);
        System.out.println();
        int playerWagerOne = scan.nextInt();
        return playerWagerOne;
    }

    //user input for bet wager two (how much player wants to bet). Don't think I need this anymore
//    public int betWagerTwo() {
//        Scanner scan = new Scanner(System.in);
//        System.out.println("What's your wager for your second bet?");
//        int playerWagerTwo = scan.nextInt();
//        return playerWagerTwo;
//    }

    // player bet input; return any (What specific bet the player chooses)
    public Scanner playerBetOne() {
        System.out.println("What are betting on? For example, if you're betting on Odd, you can type, 'Odd'");
        Scanner playerBetOne = new Scanner(System.in);
        System.out.println("Your bet has been registered!");
        return playerBetOne;
    }

//I don't think I needs this anymore
//    public Scanner playerBetTwo() {
//        System.out.println("What are betting on? For example, if you're betting on Odd, you can type, 'Odd'");
//        Scanner playerBetTwo = new Scanner(System.in);
//        System.out.println("Your bet has been registered!");
//        return playerBetTwo;
//    }

    /* The straight-up bet in roulette, is an inside bet on a single number
     (or group of single numbers). It pays out 35:1.
     */
    public int placeStraightUpBet(int wager, int bet, int balance) {
        int payOut = 0;
//        int playerBet1 = Integer.parseInt(String.valueOf(playerBetOne()));
//        int playerBet2 = Integer.parseInt(String.valueOf(playerBetTwo()));
        RouletteWheel wheel = new RouletteWheel();
        spinResult = wheel.spinWheel();
        if ((spinResult == bet)) {
            System.out.println("Your results are: " + spinResult + ". You win!");
            int winAmount = wager * 35;
            payOut = Account.deposit(userAcct, winAmount);
            System.out.println("Your pay out is " + payOut);
        } else
            System.out.println("Sorry, better luck next time! Your new balance is " + (balance - wager) + ". Please play again!");
        return payOut;
    }

    public int placeRedEvenBet(int wager, int bet, int balance) {
        int payOut = 0;
        RouletteWheel wheel = new RouletteWheel();
        spinResult = wheel.spinWheel();
        if (spinResult % 2 == 0) {
            System.out.println("Well, aren't you a lucky one. You win!");
            int winAmount = (wager * 1);
            payOut = Account.deposit(userAcct, winAmount);
            System.out.println("Your payout is " + payOut + ".");
        } else
            System.out.println("Sorry, better luck next time! Your new balance is " + (balance - wager) + ". Please play again!");
        return payOut;
    }

    public int placeBlackOddBet (int wager, int bet, int balance) {
        int payOut = 0;
        RouletteWheel wheel = new RouletteWheel();
        spinResult = wheel.spinWheel();
        if (spinResult %2 != 0) {
            System.out.println("Well, aren't you a lucky one. You win!");
            int winAmount = wager * 2;
            payOut = Account.deposit(userAcct, winAmount);
            System.out.println(" Your new balance is " + (balance + winAmount) + ".");
        } else
            System.out.println("Sorry, better luck next time! Your new balance is " + (balance - wager) + ". Please play again!");
    return balance;
    }

    public int placeFirstDozenBet (int wager, int bet, int balance) {
        int payOut = 0;
        RouletteWheel wheel = new RouletteWheel();
        spinResult = wheel.spinWheel();
        if ( (spinResult >= 1) && (spinResult <= 12)) {
            System.out.println("Well, aren't you a lucky one. You win!");
            int winAmount = wager * 2;
            payOut = Account.deposit(userAcct, winAmount);
            System.out.println(" Your new balance is " + (balance + payOut) + ".");
        } else
            System.out.println("Sorry, better luck next time! Your new balance is " + (balance - wager) + ". Please play again!");
        return balance;
        }

    public int placeSecondDozenBet (int wager, int bet, int balance) {
        int payOut = 0;
        RouletteWheel wheel = new RouletteWheel();
        spinResult = wheel.spinWheel();
        if ( (spinResult >= 13) && (spinResult <= 24)) {
            System.out.println("Well, aren't you a lucky one. You win!");
            int winAmount = wager * 2;
            payOut = Account.deposit(userAcct, winAmount);
            System.out.println(" Your new balance is " + (balance + payOut) + ".");
        } else
            System.out.println("Sorry, better luck next time! Your new balance is " + (balance - wager) + ". Please play again!");
        return balance;
    }

    public int placeThirdDozenBet (int wager, int bet, int balance) {
        int payOut = 0;
        RouletteWheel wheel = new RouletteWheel();
        spinResult = wheel.spinWheel();
        if ( (spinResult >= 25) && (spinResult <= 36)) {
            System.out.println("Well, aren't you a lucky one. You win!");
            int winAmount = wager * 2;
            payOut = Account.deposit(userAcct, winAmount);
            System.out.println(" Your new balance is " + (balance + payOut) + ".");
        } else
            System.out.println("Sorry, better luck next time! Your new balance is " + (balance - wager) + ". Please play again!");
        return balance;
    }
    }


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




