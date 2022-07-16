package com.github.zipcodewilmington.casino.games.BoulderParchmentShears;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.utils.TheScanner;

import java.util.Random;
import java.util.Scanner;

public class BPSEngine {
    Scanner scan = new Scanner(System.in);
    Random randy = new Random();
    protected static final String boulder = "boulder";
    protected static final String parchment = "parchment";
    protected static final String shears = "shears";
    Integer botRoll = 0;
    String botThrow;

    public static void intro(int numPlayers) {
        int choice;
        System.out.println("Welcome to Boulder Parchment Shears. The game of mental dominance over your foes.");
        if (numPlayers < 3) {
            System.out.println("Would you like to play against each other, or in a 3-Way match with an AI?\n" +
                    "1) Player vs. Player\n" +
                    "2) Player vs. Player vs. AI\n" +
                    "3) Return to Main Menu");
            choice = TheScanner.getNumber("");
            if (choice == 1) {
                //make bets and then get choices
            } else if (choice == 2) {
                //make bets and then get choices
            } else if (choice == 3) {
                Casino.splashScreen();
            } else System.out.println("That is not a valid menu choice, enter the number for your choice.");
        }
        if (numPlayers == 3) {
            //make bets and then get choices
        }
    }

    public static void BPSRules2P() {
        System.out.println("The rules are simple. Boulder beats Shears, Shears beats Parchment, Parchment beats Boulder.\n" +
                "You will make a wager against the other player, winner gets all. This means that if you win, you double your bet.\n");
    }

    public static void BPSRules3P() {
        System.out.println("Three player boulder parchment shears is an odd-man-IN type of game.\n" +
                "If two people throw the same object, the odd man out WINS!\n" +
                "If all three players throw the same object, it is a draw and you go again. Winner collects all bets.");
    }

    public static String getThrow(int player){
        String p1;
        System.out.println("Player " + player + ", pick your sign.\n" +
                "1) Boulder\n" +
                "2) Parchment\n" +
                "3) Shears");
        while (true) {
            int choice = TheScanner.getNumber("");
            if (choice == 1) {
                p1 = "boulder";
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            } else if (choice == 2) {
                p1 = "parchment";
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            } else if (choice == 3) {
                p1 = "shears";
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                break;
            } else System.out.println("That is not a valid choice, choose 1, 2, or 3.");
        }
        return p1;
    }




    public String BPSAI (){
        botRoll = (randy.nextInt(3)+1);
        if (botRoll == 1) {botThrow = "boulder";}
        else if (botRoll == 2) {botThrow = "parchment";}
        else botThrow = "shears";
        return botThrow;
    }
    public void BPS1P(String player1){
        String bot = BPSAI();
        getWinner2P(player1, bot);
    }
    public String getWinningMove(String handSign) {
        if (handSign.equals("boulder")) {
            return "parchment";
        } else if (handSign.equals("parchment")) {
            return "shears";
        } else return "boulder";
    }
    public String getLosingMove(String handSign) {
        if (handSign.equals("boulder")) {
            return "shears";
        } else if (handSign.equals("parchment")) {
            return "boulder";
        } else return "parchment";
    }
    public String getWinner2P(String player1, String player2) {
        String oneWinner = getLosingMove(player1);
        if (player2.equals(oneWinner)) {
            return player1;
        } else return player2;
    }

    public static String getWinner3P(String player1, String player2, String player3) {
        String draw = "draw";
        if (player1.equals(player2)) {return player3;}
        else if (player2.equals(player3)) {return player1;}
        else if (player3.equals(player1)) {return player2;}
        else return draw;
    }

}
