package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.PlayerSetup;

import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessMain {
    static boolean running = true;
    static int input;
    static NumberGuessEngine guessEngine = new NumberGuessEngine();
    static Scanner scanner = new Scanner(System.in);

    public static void playGame() {
        PlayerSetup.playerSetup(1);


        guessEngine.prompt();
        input = scanner.nextInt();
        if(input == 2) {
            running = false;
            Casino.splashScreen();
        }
        while(running){

            while(true){
                guessEngine.promptForGuess();
                //input = scanner.nextInt();
                guessEngine.getInput();
                int userGuess = guessEngine.guessNumber();
                if(userGuess == input){
                    System.out.println("Congrats you won!!!");
                    break;
                } else if (userGuess > input){
                    System.out.println("Number is higher");
                } else if (userGuess < input){
                    System.out.println("Number is lower");
                }else {
                    System.out.println("Unfortunately you lost.");
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