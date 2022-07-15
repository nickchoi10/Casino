package com.github.zipcodewilmington.casino.games.numberguess;

import java.util.InputMismatchException;
import java.util.Random;

import static com.github.zipcodewilmington.casino.games.numberguess.NumberGuessMain.scanner;

public class NumberGuessEngine {
    private Random random = new Random();
    private Integer number;

    public void setRandom(Random random) {
        this.random = random;
    }

    public Integer randomNumber(){
        this.number = random.nextInt(10) + 1;
        return this.number;
    }

    public void prompt(){
        System.out.println("Welcome to the Number Guessing Game!\nWe do not accept your money here\n");
        System.out.println("Please choose from the following: 1) Play Game 2) Quit\nEnter 1 or 2 \n");
    }

    public void promptForGuess() {
        System.out.println("Please guess a number between 1 - 10\nYou have 3 tries\n");
    }

    public void promptContinue() {
        System.out.println("Do you want to continue playing?\n1) Continue 2) Quit\n");
    }

    int getInput() {
        while (true) {
            //System.out.print("");
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
