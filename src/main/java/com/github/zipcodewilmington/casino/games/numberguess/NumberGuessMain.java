package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.Casino;

import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessMain {
    static boolean running = true;
    static int input;
    static NumberGuessEngine guessEngine = new NumberGuessEngine();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args){
        playGame();
    }

    public static void playGame() {

        guessEngine.prompt();
        input = scanner.nextInt();
        if(input == 2) {
            running = false;
            Casino.splashScreen();
        }
        while(running){
            int randomNum = guessEngine.randomNumber();
            guessEngine.promptForGuess();

            while(true){
                input = guessEngine.getInput();
                System.out.println(input);
                System.out.println(randomNum);
                if(randomNum == input){
                    System.out.println("Congrats you won!!!");
                    break;
                } else if (randomNum > input){
                    System.out.println("Number is higher, try again");
                } else if (randomNum < input){
                    System.out.println("Number is lower, try again");
                }
            }
            guessEngine.promptContinue();
            input = scanner.nextInt();
            if(input == 1){
                continue;
            } else if (input == 2) {
                running = false;
                Casino.splashScreen();
            }
        }
    }
}