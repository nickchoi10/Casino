package com.github.zipcodewilmington.casino.games.dicegames;

import java.util.Random;


public class Dice {
    private Random random = new Random();
    private Integer number;
    private Integer results;
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_BLUE = "\u001B[34m";

    public Dice() {

    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Integer rollDice() {
        this.number = random.nextInt(6) + 1;
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        diceASCII(this.number);
        return this.number;
    }

    public Integer getNumber() {
        return this.number;
    }

    public int tossAndSum(int numOfDice) {
        this.results = 0;
        for (int i = 0; i < numOfDice; i++) {
            this.results += rollDice();
        }
        return this.results;
    }

    public Integer getResults() {
        return results;
    }

    public void unicodeDice(){
        //Unicode Dice
        String d = String.valueOf((Character.toChars(0x0001F3B2)));
        String d1 = String.valueOf((Character.toChars(0x00002680)));
        String d2 = String.valueOf((Character.toChars(0x00002681)));
        String d3 = String.valueOf((Character.toChars(0x00002682)));
        String d4 = String.valueOf((Character.toChars(0x00002683)));
        String d5 = String.valueOf((Character.toChars(0x00002684)));
        String d6 = String.valueOf((Character.toChars(0x00002685)));
    }

    public void diceASCII(Integer results){
        //ASCII Dice
        if(results == 1) {
            System.out.println(ANSI_CYAN+
                    "-----\n" +
                    "|   |\n" +
                    "| o |\n" +
                    "|   |\n" +
                    "-----"+ANSI_BLUE);
        } else if (results == 2){
            System.out.println(ANSI_CYAN+
                    "-----\n" +
                    "|o  |\n" +
                    "|   |\n" +
                    "|  o|\n" +
                    "-----"+ANSI_BLUE);
        } else if (results == 3){
            System.out.println(ANSI_CYAN+
                    "-----\n" +
                    "|o  |\n" +
                    "| o |\n" +
                    "|  o|\n" +
                    "-----"+ANSI_BLUE);

        } else if (results == 4){
            System.out.println(ANSI_CYAN+
                    "-----\n" +
                    "|o o|\n" +
                    "|   |\n" +
                    "|o o|\n" +
                    "-----"+ANSI_BLUE);
        } else if (results == 5){
            System.out.println(ANSI_CYAN+
                    "-----\n" +
                    "|o o|\n" +
                    "| o |\n" +
                    "|o o|\n" +
                    "-----"+ANSI_BLUE);
        } else if (results == 6){
            System.out.println(ANSI_CYAN+
                    "-----\n" +
                    "|o o|\n" +
                    "|o o|\n" +
                    "|o o|\n" +
                    "-----"+ANSI_BLUE);
        }
    }
}
