package com.github.zipcodewilmington.casino.games.dicegames;

import java.util.Random;


public class Dice {
    private Random random = new Random();
    private Integer number;
    private Integer results;

    public Dice() {

    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Integer rollDice() {
        this.number = random.nextInt(6) + 1;
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
            System.out.println(
                    "-----\n" +
                    "|   |\n" +
                    "| o |\n" +
                    "|   |\n" +
                    "-----");
        } else if (results == 2){
            System.out.println(
                    "-----\n" +
                    "|o  |\n" +
                    "|   |\n" +
                    "|  o|\n" +
                    "-----");
        } else if (results == 3){
            System.out.println("-----\n" +
                    "|o  |\n" +
                    "| o |\n" +
                    "|  o|\n" +
                    "-----");

        } else if (results == 4){
            System.out.println(
                    "-----\n" +
                    "|o o|\n" +
                    "|   |\n" +
                    "|o o|\n" +
                    "-----");
        } else if (results == 5){
            System.out.println(
                    "-----\n" +
                    "|o o|\n" +
                    "| o |\n" +
                    "|o o|\n" +
                    "-----");
        } else if (results == 6){
            System.out.println(
                    "-----\n" +
                    "|o o|\n" +
                    "|o o|\n" +
                    "|o o|\n" +
                    "-----");
        }

    }
}
