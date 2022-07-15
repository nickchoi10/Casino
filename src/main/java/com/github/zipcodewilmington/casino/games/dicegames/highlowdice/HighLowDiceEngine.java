package com.github.zipcodewilmington.casino.games.dicegames.highlowdice;

import java.util.InputMismatchException;
import java.util.Scanner;


public class HighLowDiceEngine {
    static Scanner scanner = new Scanner(System.in);
    Integer results;

    //**********||GAME METHODS||**********//
    public Integer placeBets() {
        //System.out.println("Place your bets!");
        //getInput().setBets;
        return null;
    }
    public Integer resolveBets() {
        //balance += getBets;
        //balance = getBets * 4 //if results is Seven
        return null;
    }
    public Integer checkHighOrLow(int diceResult) {
        int results = 0;
        if (diceResult > 7) {
            results = 1; //High
        } else if (diceResult < 7){
            results = 2; //Low
        } else if (diceResult == 7) {
            results = 3; //7 is middle
        }
        return results;
    }

    public void resultsCheck(int highOrLow){
        if(highOrLow == 1){
            results = 1; //1 is high
            System.out.println("The result is High!!!\n");
        } else if (highOrLow == 2){
            results = 2; //2 is low
            System.out.println("The result is Low!!!\n");
        } else if (highOrLow == 3) {
            results = 3; //3 is seven
            System.out.println("The result is Seven!!!\n");
        }
    }

    public void winOrLose(int playerInput, int highOrLow){
        if (playerInput == highOrLow) {
            System.out.println("You win!!\n");
        } else {
            System.out.println("You lose!!\n");
        }
    }

    //**********||PROMPTS||**********//
    public void startPrompt() {
        System.out.println("Welcome to High Low Dice Game\n");
        System.out.println("Please choose from the following: \n1) Play Game\n2) Quit\n3) Rules\nEnter 1, 2, or 3 \n");
    }

    public void instructionsPrompt() {
        System.out.println("Rules!\nThe outcome is considered:\nHigh if the sum of the dice is 8, 9, 10, 11, 12.\nLow if the sum of the dice is 1, 2, 3, 4, 5, 6.\nSeven is the outcome is 7.\n\nPlace your bets on High, Low, or Seven\nPayout is 1-1 for High and Low.\nPayout is 4-1 for Seven.\n");
    }
    public void highLowPrompt(){
        System.out.println("Enter a number: 1) High 2) Low 3) Seven\n");
    }

    //**********||INPUTS||**********//
    public int getInput() {
        while (true) {
            try {
                int input = scanner.nextInt();
                if (input >= 0) {
                    return input;
                }
                throw new IllegalArgumentException("number is negative");
            } catch (IllegalArgumentException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a positive number!");
            } catch (InputMismatchException e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }
}
